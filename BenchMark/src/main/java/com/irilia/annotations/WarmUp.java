package com.irilia.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//系统预热
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WarmUp {
    int iterations() default 2000;
}
