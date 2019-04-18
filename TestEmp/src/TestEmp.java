import java.lang.reflect.Method;

public class TestEmp {
    public static void main(String[] args) {
        String value = "name:张三|job:laoshi";
        String[] attributeNameValues =
    }


    public static void srtXxx(Object object,String name,String job){
        Class classz = object.getClass();
        String setMethodName = "set" + name.substring(0,1).toUpperCase()+(name.length()>1? name.substring(1): "");
        try {
            Method setMethod = classz.getMethod(setMethodName,name.getClass());
            setMethod.invoke(object,value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //通过Field也可以修改

    }
}
