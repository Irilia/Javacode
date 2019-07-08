package chartroom.single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//服务器
public class SingleThreadServer {
    public static void main(String[] args) throws IOException {
        //1.建立基站
        ServerSocket serverSocket = new ServerSocket(6667);
        //2.等待客户端的连接
        System.out.println("等待客户端连接。。。");
        Socket client = serverSocket.accept();
        System.out.println("客户端连接成功，端口号为："+client.getPort());
        //3.读取客户端发来的信息
        Scanner in = new Scanner(client.getInputStream());
        if(in.hasNextLine()) {
            System.out.println("客户端发来的消息为："+in.nextLine());
        }
        //向客户端发送一条消息
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("hi, I am a servet");
        //关闭流
        out.close();
        in.close();
        serverSocket.close();
    }
}
