package com.irilia.client.server;

import com.irilia.client.vo.MessageVo;
import com.irilia.util.CommUtil;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//服务端，支持多线程
public class MultiThreadServer {
    //从配置文件中加载配置信息
    private static Integer PORT;
    static {
        //加载配置文件
        Properties pros = CommUtil.loadProperties("socket.properties");
        //配置文件默认都是String类型的，所以用包装类转一下
        PORT = Integer.valueOf(pros.getProperty("PORT"));
    }

    //服务端缓存所有连接的客户端对象：根据每个对象的名称来确认每个客户端对象---map的键值对
    //用ConcurrentHashMap线程安全，防止用户名重复
    private static Map<String, Socket> clients = new ConcurrentHashMap<>();
    //缓存所有群名称以及群中的成员姓名
    private static Map<String,Set<String>> groupInfo = new ConcurrentHashMap<>();

    //服务端具体处理客户端请求的任务:获得线程，运行线程
    private static class ExecuteClient implements Runnable{
        private Socket client;
        private Scanner in;
        private PrintStream out;

        public ExecuteClient(Socket client) {
            this.client = client;
            try {
                this.in = new Scanner(client.getInputStream());
                this.out = new PrintStream(client.getOutputStream(),true,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            //获取到客户端的输入输出流
            while(true){
                if(in.hasNextLine()){
                    String strFromClient = in.nextLine();
                    MessageVo msgFromClient = (MessageVo) CommUtil.jsonToObject(strFromClient,MessageVo.class);
                    if(msgFromClient.getType().equals(1)){
                        //新用户的注册
                        String userName = msgFromClient.getContent();
                        //将当前聊天室在线好友信息发回给新用户
                        Set<String> names = clients.keySet();
                        MessageVo msgToClient = new MessageVo();
                        msgToClient.setType(1);
                        msgToClient.setContent(CommUtil.objectToJson(names));
                        //吧信息发回给客户端
                        out.println(CommUtil.objectToJson(msgToClient));
                        //将新用户的上线信息发给其他在线用户
                        String loginMsg = "newLogin:"+userName;
                        for(Socket socket : clients.values()){
                            PrintStream out = null;
                            try {
                                out = new PrintStream(socket.getOutputStream(),true,"UTF-8");
                                out.println(loginMsg);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        //将新用户的信息保存到当前服务端缓存
                        System.out.println(userName+"上线了！");
                        clients.put(userName,client);
                        System.out.println("当前聊天室在线人数为："+clients.size());
                    }else if(msgFromClient.getType().equals(2)){
                        //私聊信息,直接转发信息
                        //得到要转发的用户名
                        String friengName = msgFromClient.getTo();
                        //得到这个用户的服务线程
                        Socket socket = clients.get(friengName);
                        //转发信息
                        try {
                            PrintStream out = new PrintStream(socket.getOutputStream(),
                                    true,"UTF-8");
                            MessageVo msgToClient = new MessageVo();
                            msgToClient.setType(2);
                            msgToClient.setContent(msgFromClient.getContent());
                            out.println(CommUtil.objectToJson(msgToClient));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }else if(msgFromClient.getType().equals(3)){
                        //注册群信息,提取内容:群名字，群成员
                        String groupName = msgFromClient.getContent();
                        //吧json串返回一个Set集合
                        Set<String> friends = (Set<String>) CommUtil.jsonToObject(msgFromClient.getTo(),Set.class);
                        //吧群信息保存在缓存中
                        groupInfo.put(groupName,friends);
                        System.out.println("注册群成功，当前共有"+groupInfo.size()+"个群");
                    }else if(msgFromClient.getType().equals(4)){
                        String groupName = msgFromClient.getTo();
                        Set<String> friends = groupInfo.get(groupName);
                        //将群聊信息转发到相应的客户端
                        Iterator<String> iterator = friends.iterator();
                        while(iterator.hasNext()){
                            String clientName = iterator.next();
                            //取得该名称对应的socket流
                            Socket client = clients.get(clientName);
                            try {
                                PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                                //type：4
                                //content:senderName-msg
                                //to:groupName-[群好友列表]
                                MessageVo messageVo = new MessageVo();
                                messageVo.setType(4);
                                messageVo.setContent(msgFromClient.getContent());
                                messageVo.setTo(groupName+"-"+CommUtil.objectToJson(friends));
                                out.println(CommUtil.objectToJson(messageVo));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
    //  服务端主方法
    public static void main(String[] args) throws IOException {
        //1.建立基站：传本地的端口号，端口号是配置类的信息，都写在配置文件中。
        ServerSocket serverSocket = new ServerSocket(PORT);
        //调用内置线程池来创建线程
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        //当主方法跑完，说明50个线程已经全部运行了，再建立新的线程就要阻塞等待
        for(int i = 0;i<50;i++){
            System.out.println("等待客户端连接");
            Socket client = serverSocket.accept();
            System.out.println("有新的连接，端口号为："+client.getPort());
            //处理客户端的任务
            executorService.submit(new ExecuteClient(client));
        }
    }
}
