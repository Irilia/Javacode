package company;

//import com.cases.Sortcases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {
        CasesLoader loader=new CasesLoader();
        loader.load().run();
    }
}
