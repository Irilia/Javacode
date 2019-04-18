public class BeanUtils {
    //工具类，可以复用
    public static void setXxx(Object object,String attributeName,Object attributeValue){}
    /**
     * 对象的属性值拷贝
     * 将source中的属性值赋值带target对象中的属性，属性名一样，属性值一样
     *
     * source：
     * String name;
     * String address;
     * Integer age;
     * Date brithday;
     *
     * target:
     * String name;
     * String address;
     * String email;
     *
     * 结果：source中的name和address拷贝到target中的name和address
     * */
    public static void copy(Object source,Object target){
        //
    }
}
