package com.bite.xml.read;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 关于dom4j的使用
 * 1）创建解析器对象
 * 2）读取资源配置xml文件
 * 3）获取document：文档（xml文档）
 */
public class Demo1 {
    public static void main(String[] args)throws Exception {
        //throws /throw
        //1）创建解析器对象
        SAXReader reader = new SAXReader();
        //2)读取资源配置xml文件
        //URL:1）通过类加载器获取URL
         //2)使用绝地路径
        Document doc = reader.read(Demo1.class.getClassLoader().
                getResource("contact.xml"));
        System.out.println(doc);
        /*
        * org.dom4j.tree.DefaultDocument@58372a00
        * [Document: name file:/E:/develop/mybatis_Gen/Java7_xml_tomcat/target/classes/contact.xml]

         * */
    }
}
