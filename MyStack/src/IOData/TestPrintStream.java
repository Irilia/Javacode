package IOData;

import java.io.*;
import java.util.Scanner;

public class TestPrintStream {
    public static void main(String[] args) throws IOException {
        File file = new File("C:"+File.separator+"Users"+File.separator+"Rachel"
                +File.separator+"Desktop"+File.separator+"hello.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        /*PrintStream printStream = new PrintStream(new FileOutputStream(file));
        printStream.println("学习Java");
        printStream.println("学习html");
        printStream.println("月薪3万");*/
    }
}

