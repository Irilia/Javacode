package com.irilia.xml.read;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*获取属性
* 前提：获取属性所在的标签对象
*   1.attributeValues(String nema):获取属性值：通过属性名称获取属性内容
*   2.attribute(String s):获取属性对象
*   */
public class TestXml3 {
    public static void main(String[] args) throws Exception{
        //1.创建解析器对象并读取xml文件
        Document doc = new SAXReader().
                read(TestXml3.class.getClassLoader().getResource("contact.xml"));
        //2.获取contact标签属性 id = “001”
        //获取contact标签
        Element conElem = doc.getRootElement().element("contact");

        //两种方式获取属性内容：
        //1.attributeValues(String nema):通过属性名称获取属性内容
        String idAtte = conElem.attributeValue("id");
        System.out.println(idAtte);

        System.out.println("-----------");
        //2.通过该标签对象获取属性对象
        Attribute attr = conElem.attribute("id");
        //getName():获取属性名称
        //getValue():获取属性值
        System.out.println(attr.getName()+"="+attr.getValue());
        System.out.println("-------------------");
        //获取标签的文本
        //dom解析中可以将空格和换行依次进行解析
        //获取name标签的文本内容
        //前提：获取name标签对象
        Element nameElem = doc.getRootElement().element("contact").element("name");
        //1.通过getText()方法获取文本内容
        System.out.println(nameElem.getText());
        //2.通过传递子标签名称获取子标签的文本内容
        //前提：获取他的父标签对象
       conElem = doc.getRootElement().element("contact");
       //elementText("子标签名称")：子标签文本的内容
       String address = conElem.elementText("address");
        System.out.println(address);
    }
}
