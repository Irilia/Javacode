package com.irilia.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//存在阶段：运行时期
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Measurement {
    //一组实验调用方法多少次
    int iterations();
    //一共进行多少组实验
    int group();
}
