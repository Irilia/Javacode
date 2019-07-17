package com.irilia.xml.write;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;

/*
 *      与添加相关：
 *              1.创建一个空文档
 *              2.添加根标签，添加子标签，添加属性。。
* 读取xml文件
*       与编辑相关的：
*                1.修改标签属性
*                2.修改标签文本
*        与删除相关的：
*                1.删除标签属性
*                2.删除指定标签
* 输出xml文件（指定磁盘上）*/
public class Demo2 {
    public static void main(String[] args) throws  Exception{
        //添加相关的
        //创建一个空文档
        //DocumentHelper:文档对象帮助类
        Document doc = DocumentHelper.createDocument();
        //通过文档对象，添加根节点 addElement("标签名称")
        doc.addElement("contact-list");

        //输出
        OutputStream out = new FileOutputStream("e:/contact.xml");
        //输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //创建输出对象
        XMLWriter writer = new XMLWriter(out,format);
        //把document文件写到硬盘上
        writer.write(doc);
        //释放资源
        writer.close();
    }
}
