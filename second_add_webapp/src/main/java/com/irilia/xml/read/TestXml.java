package com.irilia.xml.read;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/*关于dom4j的使用
* 1.创建解析器对象
* 2.读取资源配置xml文件
* 3.获取document对象：xml文档*/
public class TestXml {
    public static void main(String[] args) throws Exception{
        //1.创建解析器对象
        SAXReader reader= new SAXReader();
        //2.读取资源配置xml文件
        //URL:
        //1.通过类加载器获取URL
        //2.使用绝对路径
        Document doc = reader.read(TestXml.class.getClassLoader().
                getResource("contact.xml"));
        System.out.println(doc);
        /*org.dom4j.tree.DefaultDocument@58372a00
        [Document: name file:/E:/Github%e5%ba%93/Javacode/second_add_webapp/target/classes/contact.xml]*/
    }
}
