import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc =  reader.read(Demo1.class.getClassLoader().getResource("test.xml"));
        System.out.println(doc);
    }
}
