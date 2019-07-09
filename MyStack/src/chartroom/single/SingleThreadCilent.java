package chartroom.single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
//客户端
public class SingleThreadCilent {
    public static void main(String[] args) throws IOException {
        //1.先与服务器建立连接
        Socket client = new Socket("127.0.0.1",6667);
        System.out.println("与服务器成功建立连接");
        //2. 拿到输出流向服务器发送一条消息。
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("hi, I am a client");
        //3.拿到输入流读取服务器输入的信息
        Scanner in = new Scanner(client.getInputStream());
        if(in.hasNextLine()){
            String str = in.nextLine();
            System.out.println("服务器发来的信息为："+str);
        }
        //关闭流
        client.close();
        in.close();
        out.close();
    }
}
