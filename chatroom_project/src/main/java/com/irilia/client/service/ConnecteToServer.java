package com.irilia.client.service;

import com.irilia.util.CommUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;

//封装了客户端与服务端建立的连接，以及输入输出流。
public class ConnecteToServer {
    //建立连接的过程
    private static final int PORT;
    private static final String IP;
    private Socket client;
    private InputStream in;
    private OutputStream out;

    static {
        Properties pros = CommUtil.loadProperties("socket.properties");
        PORT = Integer.parseInt(pros.getProperty("PORT"));
        IP = pros.getProperty("IP");
    }

    //构造方法：每次产生一个对象，表示需要和服务器建立连接
    public ConnecteToServer(){
        //和服务器建立连接
        try {
            client = new Socket(IP,PORT);
            this.in = client.getInputStream();
            this.out = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getIn() {
        return in;
    }

    public OutputStream getOut() {
        return out;
    }
}
