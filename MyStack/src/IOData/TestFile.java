package IOData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestFile {
    public static void main(String[] args) throws IOException {
        //1.取得终端对象
        File file = new File(File.separator+"E:"+File.separator+"JavaSE全套课件"+File.separator+"TestFile.txt");
        /*if(file.exists() && file.isDirectory()){
            listAllFiles(file);
        }*/
        /*if(file.exists()) {
            file.delete();
        }else{
            file.createNewFile();
        }
        if(file.exists() && file.isFile()){
            System.out.println("文件大小是："+file.length()+"字节");
        }*/
        //有输出流可以不用创建文件，只要路径正确就会自动创建文件
        //2.取得相应终端的输出流
        OutputStream outputStream = new FileOutputStream(file);
        //3.将数据通过输出流输出
        outputStream.write("hello World\n".getBytes());
        //4.关闭输出流
        outputStream.close();


    }
    /*private static void listAllFiles(File file){
        if(file != null){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File temp : files){
                    listAllFiles(temp);
                }
            }else{
                System.out.println(file);
            }
        }
    }*/
    private static void listAllFiles(File file){
        if(file != null){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File temp: files){
                    listAllFiles(temp);
                }
            }else{
                System.out.println(file);
            }
        }

    }

    private static void listAllFiles1(File file){
        if(file != null){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File temp: files){
                    listAllFiles(temp);
                }
            }else{
                System.out.println(file);
            }
        }
    }

}
