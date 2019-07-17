package com.irilia.xml.write;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;

/*API书写格式：
1.创建输出对象
* XMLWriter writer = new XMLWriter(
*       new FileWriter("output.xml")
* );
* 2.将文档输出到硬盘
*       writer.write(document);
*       3.释放资源
*       writer.close();
*/
public class Demo1 {
    public static void main(String[] args) throws Exception{
        //1.使用dom解析器获取到document对象
        Document doc =  new SAXReader().
                read(Demo1.class.getClassLoader().
                        getResource("contact.xml"));
        //2.将document对象从内存中输出到硬盘上
        //XMLWriter(OutputStream out,OutputFormat format)
        //创建一个输出流对象
        OutputStream out = new FileOutputStream("E:/contact.xml");
        //指定输出细节：OutputFormat：xml文件的输出格式
        //OutputFormat:没有指定输出格式（createPretyPrint():空格换行的标准格式）
        //指定当前输出到硬盘上的编码格式
        //format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out);
        //3.将document对象写到指定的磁盘下
        writer.write(doc);
        //4.释放资源
        writer.close();
    }
}
