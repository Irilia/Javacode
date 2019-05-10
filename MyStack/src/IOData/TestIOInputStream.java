package IOData;

import java.io.*;

public class TestIOInputStream {
    public static void main(String[] args) {
        //1。准备文件
        File file = new File("C:"+File.separator+"Users"
                +File.separator+"Rachel"+File.separator+"Desktop"+File.separator+"hello.txt");
        OutputStream out = null;
        try {
            //2.创建输出流对象
            out = new FileOutputStream(file,true);
            //3.输出内容
            out.write("hello java!".getBytes());
            //4.刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5.关闭流
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
