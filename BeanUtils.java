

package com.bittech.sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class BeanUtils {

    public static void setXxx(Object object, String attributeName, Object attributeValue) {
        Class classz = object.getClass();
        String setMethodName = "set" + attributeName.substring(0, 1).toUpperCase()
                + (attributeName.length() > 1 ? attributeName.substring(1) : "");
        try {
            Method setMethod = classz.getMethod(setMethodName, attributeValue.getClass());
            setMethod.invoke(object, attributeValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * 对象的属性值拷贝
     * <p>
     * 将source对象中的属性值赋值到target对象中的属性，属性名一样，类型一样
     * <p>
     * example:
     * <p>
     * source:
     * <p>
     * String name;
     * String address;
     * Integer age;
     * Date   birthday;
     * <p>
     * target:
     * String name;
     * String address;
     * String email
     * <p>
     * 结果： source name, address -> target name, address
     *
     * @param source
     * @param target
     */
    public static void copy(Object source, Object target) {
        Source source1 = new Source();
        source1.setName("Jack");
        source1.setAddress("xian");
        source1.setAge(22);
        source1.setBirthday("2002-12-15");
        Class sourceClass = source1.getClass();

    }
}

class Source{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private String name;
    private String address;
    private Integer age;
    private Date birthday;
}

class Target{
    private String name;
    private String address;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}