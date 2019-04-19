package com.bittech.reflect;

/*
1. 获取Class对象的三种方式
第一种：通过类的实例化对象的getClass方法获取
第二种：通过类名.class获取
第三种：通过Class类的静态方法forName(类的全限定名)获取

2. 类的实例化对象方法
第一种：通过类的构造方法实例化对象
第二种：2.1 通过类的Class对象的newInstance方法实例化对象
           局限性：类必须有无参数的构造方法
       2.2 通过类的Class对象获取Constructor对象，
           Constructor的newInstance(Class ...parameterTypes)
           实例化对象
第三种：序列化和反序列化
 */