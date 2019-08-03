package com.irilia.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义注解
//注解是一类接口，此接口不能被继承（其实可以。。）
@Retention(RetentionPolicy.RUNTIME)//针对运行时注解
@Target(ElementType.METHOD)//目标注解：只修饰方法的注解
public @interface BenchMark {

}
