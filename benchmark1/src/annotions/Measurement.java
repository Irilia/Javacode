package annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//注解可以保留到程序运行的时候，它会被加载进入到 JVM 中
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface Measurement {
    int iterations();//执行次数
    int group();//执行组数

}
