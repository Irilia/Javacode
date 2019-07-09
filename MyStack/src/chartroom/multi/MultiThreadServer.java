package chartroom.multi;

import jdk.nashorn.internal.ir.ReturnNode;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    //保存所有连接的客户端，就是Socket对象，用类集保存一组对象
    //客户端需要用用户名来表示,用Map集合
    private static Map<String, Socket> clientMap = new ConcurrentHashMap<>();
    //服务器端只要负责转发信息即可，不需要有输入，所以用一个内部类
    private static class ExecuteClientMSg implements Runnable {
        private Socket client;

        public ExecuteClientMSg(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            //获取客户端的输入流
            Scanner in = null;
            try {
                in = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true) {
                if(in.hasNextLine()) {
                    String msgFromCline = in.nextLine();
                    //用户注册R：用户名
                    if(msgFromCline.startsWith("R:")) {
                        //注册流程
                        String userName = msgFromCline.split(":")[1];
                        try {
                            userReg(userName,client);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    //私聊 P：私聊对象的用户名-发送的信息
                    if(msgFromCline.startsWith("P:")){
                        //私聊流程，只选取与userName相同client获取他的输入输出流
                        String userName = msgFromCline.split(":")[1].split("-")[0];
                        String msg = msgFromCline.split("-")[1];
                        try {
                            privateChat(userName,"私聊信息为："+msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    //群聊：G：msg
                    if(msgFromCline.startsWith("G:")) {
                        //群聊流程
                        String groupChatMsg = msgFromCline.split(":")[1];
                        try {
                            groupChat("群聊消息为："+groupChatMsg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        //私聊流程
        private void privateChat(String userName,String msg) throws IOException {
            Socket client = clientMap.get(userName);
            PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
            out.println(msg);
        }
        //注册流程
        private void userReg(String userName,Socket client) throws IOException {
            //将客户端注册到当前的服务器
            clientMap.put(userName,client);
            System.out.println("当前聊天室中共有"+clientMap.size()+"人");
            String msg = "用户"+userName+"已上线！";
            System.out.println(msg);
            groupChat(msg);
        }
        //群聊流程
        private void groupChat(String msg) throws IOException {
            //获取Map中的所有客户端，拿到他们的输出流
            Collection<Socket> sockets = clientMap.values();
            for (Socket client: sockets) {
                PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                out.println(msg);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6667);
        //控制多个客户端，就要有多个线程，用线程池管理线程
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            System.out.println("等待客户端连接");
            Socket client = serverSocket.accept();
            //已经有一个客户连接到服务器了，就新建一个线程处理客户端的下一个连接。
            System.out.println("有新的客户端连接，端口号为："+client.getPort());
            service.submit(new ExecuteClientMSg(client));
        }
        serverSocket.close();
    }

}
