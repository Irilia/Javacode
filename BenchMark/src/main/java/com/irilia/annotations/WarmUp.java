package com.irilia.annotations;
//系统预热
public @interface WarmUp {
    int iterations() default 0;
}
