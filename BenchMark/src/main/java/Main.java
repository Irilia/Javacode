/*
import com.irilia.annotations.BenchMark;
import com.irilia.annotations.Measurement;
import cases.StringContacteCase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //实验如何进行，第一级的默认配置
        int iterations = 10;//默认配置
        int group = 5;//默认配置

        //第二级的配置（类级别）
        StringContacteCase object = new StringContacteCase();
            //通过反射获取类中定义的方法
        Class<?> cls = object.getClass();
        Annotation annMeasurement = cls.getAnnotation(Measurement.class);
        if(annMeasurement != null){
            Measurement measurement = (Measurement)annMeasurement;
            iterations = measurement.iterations();
            group = measurement.group();
        }

        Method[] methods = cls.getMethods();//获取注解

        //如果方法中没有benchmark注解，就不属于要进行测试的方法，跳过该方法
        for(Method method:methods){
            Annotation annoBanchMark = method.getAnnotation(BenchMark.class);
            if(annoBanchMark == null){
                continue;
            }

            //针对方法的配置
            int methodIterations = iterations;
            int methodGroup = group;
            System.out.println(method.getName());
            Annotation methodAnnotation = method.getAnnotation(Measurement.class);
            if(methodAnnotation != null){
                Measurement methodMeasurement = (Measurement)methodAnnotation;
                methodIterations = methodMeasurement.iterations();
                methodGroup = methodMeasurement.group();
            }

            //真正的测试，调用对象的测试实例方法
            for (int i = 0; i < methodGroup; i++) {
                long t1 = System.nanoTime();
                for (int j = 0; j < methodIterations; j++) {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                long t2 = System.nanoTime();
                System.out.printf("第%d次试验，耗时：%d%n",i,t2-t1);
            }

        }
    }
}
*/
