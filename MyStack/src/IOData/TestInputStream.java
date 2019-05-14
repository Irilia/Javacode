package IOData;

import java.io.*;

public class TestInputStream {
    public static void code1(){
        //1.取得终端对象
        File file = new File("C:"+File.separator+"Users"
                +File.separator+"Rachel"+File.separator+"Desktop"+File.separator+"hello.txt");
        //2.输入流
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            int len = 0;
            byte[] b = new byte[1024];
            len = in.read(b,0,len);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length != 2){
            System.out.println("拷贝错误");
        }
        //源文件
        File souceFile = new File(args[0]);
        //目标文件
        File destFile = new File(args[1]);
        InputStream in = new FileInputStream(souceFile);
        OutputStream out = new FileOutputStream(destFile);

    }
    private static void copyFile(InputStream in,OutputStream out) throws IOException {
        System.out.println("拷贝开始");
        long start = System.currentTimeMillis();
        int len = 0;
        byte[] data = new byte[1024];
        while((len = in.read(data)) != -1){
            out.write(len);
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝结束，共耗时"+(end-start)+"毫秒");

    }
}
