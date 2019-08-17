package com.irilia.client.server;

import com.irilia.util.CommUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//服务端
public class MultiThreadServer {
    private static Integer PORT;
    static {
        Properties pros = CommUtil.loadProperties("scoket.properties");
    }
    //服务端缓存所有连接的客户端对象
    private static Map<String, Socket> clients = new ConcurrentHashMap<>();
    //服务端具体处理客户端请求的任务
    private static class ExecuteClient implements Runnable{
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) throws IOException {
        //1.建立基站
        ServerSocket serverSocket = new ServerSocket(PORT);
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for(int i = 0;i<50;i++){
            System.out.println("等待客户端连接");
            Socket client = serverSocket.accept();
            System.out.println("有新的连接，端口号为："+client.getPort());
            executorService.submit(new ExecuteClient());
        }
    }
}
