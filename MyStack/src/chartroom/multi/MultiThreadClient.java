package chartroom.multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//基于多线程的客户端
public class MultiThreadClient {
    //发送信息线程,需要连接的输入输出流，所以要将连接传进来。
    //用构造方法传入
    private static class SendMsgToServer implements Runnable {
        private Socket client;

        public SendMsgToServer(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            //获取键盘输入流
            Scanner in = new Scanner(System.in);
            PrintStream out2Server = null;
            try {
                out2Server = new PrintStream(client.getOutputStream(),true,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true) {
                if(in.hasNextLine()) {
                    String str2Server = in.nextLine();
                    //将信息发送到服务器端
                    out2Server.println(str2Server);
                    //客户端退出标志
                    if(str2Server.contains("byby")){
                        System.out.println("客户端退出");
                        break;
                    }
                }
            }
            //关闭流
            in.close();
            out2Server.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读取信息的线程
    private static class ReadMsgFromServer implements Runnable {
        private Socket client;

        public ReadMsgFromServer(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            Scanner in = null;
            try {
                 in = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true) {
                if(client.isClosed()) {
                    System.out.println("客户端已经退出了");
                    break;
                }
                if(in.hasNextLine()) {
                    String strFromServer = in.nextLine();
                    System.out.println("服务器发来的信息为："+strFromServer);
                }
            }
            in.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",6667);
        //新建读取与发送线程
        Thread readThread = new Thread(new ReadMsgFromServer(client));
        Thread sendThread = new Thread(new SendMsgToServer(client));
        readThread.start();
        sendThread.start();
    }
}
