package TypeUnit;

import java.io.File;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("xa","西安");
        properties.setProperty("bj","北京");
        properties.setProperty("sh","上海");
        properties.setProperty("hz","杭州");
        //System.out.println(properties.getProperty("xa"));
        //System.out.println(properties.getProperty("gz","城市"));
        File file = new File("");
    }
}
