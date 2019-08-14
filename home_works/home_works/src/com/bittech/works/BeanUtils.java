package com.bittech.works;

import java.lang.reflect.Field;

public class BeanUtils {

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
        //1. 通过Field赋值
        //2. 通过setter方法
        //选择第1种方式
        //第一步：参数校验
        if (source == null || target == null) {
            throw new IllegalArgumentException("copy parameters source and target must be not null.");
        }
        //第二步：获取source和target对象的类型的Class对象
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        //第三步：获取sourceClass和targetClass的属性
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        //第四步：进行属性赋值
        for (Field sourceField : sourceFields) {
            for (Field targetField : targetFields) {
                //名称，类型
                if (sourceField.getName().equals(targetField.getName())
                        && sourceField.getType().equals(targetField.getType())) {
                    //赋值
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    try {
                        Object value = sourceField.get(source);
                        targetField.set(target, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
