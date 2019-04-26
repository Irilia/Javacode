package com.bit.main;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class BeanUtils {

   /* public static void setXxx(Object object, String attributeName, Object attributeValue) {
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

    }*/


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
     *
     * 1.直接通过Field赋值
     * 2.通过setter方法
     * 选择第一种
     */
    public static void copy(Object source, Object target) {
        //第一步，参数校验
        if(source == null || target == null){
            throw new UnsupportedOperationException("Unsupported Null");
        }

        //2.获取source和target对象的类型的Class对象
        Class soutceClass = source.getClass();
        Class targetClass = target.getClass();
        //3。获取sourceClass和targetClass的属性
        Field[] soutceFields = soutceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        //4.进行属性赋值
        for (Field soutceField :soutceFields) {
            for (Field targetField:targetFields) {
                //名称类型都一样才能拷贝
                if(soutceField.getName().equals(targetField.getName())
                        && soutceField.getType().equals(targetField.getType())) {
                    //赋值，反射机制用Accessible使属性可改
                    try {
                        Object value = soutceField.get(source);
                        targetField.set(target,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}

