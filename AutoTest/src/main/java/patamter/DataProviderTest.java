package patamter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test
    @Parameters({"name","age"})
    public void test1(String name ,int age){
        System.out.println("name = "+name+";  age = "+age);
    }
}
