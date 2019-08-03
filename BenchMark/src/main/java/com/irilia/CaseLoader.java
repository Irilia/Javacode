package com.irilia;

import com.irilia.annotations.BenchMark;
import com.irilia.annotations.Measurement;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class CaseRunner{
    private static final int DEFAULT_ITERATIONS = 10;
    private static final int DEFAULT_GROUP = 5;
    private final List<Case> caseList;

    public CaseRunner(List<Case> caseList){
        this.caseList = caseList;
    }
    //指定配置选项
    //TODO：没有吧Warmup预热考虑进来，每组实验之前都应该预热
    public void run() throws InvocationTargetException, IllegalAccessException {
        //运行：一个一个运行
        for(Case bCase:caseList){
            //找到对象中哪些方法是需要测试的方法，哪些是不需要测试的方法
            //找到所有的方法，看方法中有没有包含Benchmark注解
            //1.得到所有的方法
            Method[] methods = bCase.getClass().getMethods();
            for(Method method: methods){
                int interations = DEFAULT_ITERATIONS;
                int group = DEFAULT_GROUP;
                //从类中获取类级别的默认值（配置）
                Measurement classMeasurement = bCase.getClass().getAnnotation(Measurement.class);
                //不为空说明配置了
                if(classMeasurement != null){
                    interations = classMeasurement.iterations();
                    group = classMeasurement.group();
                }
                //2.取得每个方法的注解
                BenchMark benchMark = method.getAnnotation(BenchMark.class);
                //如果是空，表明是不需要处理的方法，继续判断下一个
                if(benchMark == null){
                    continue;
                }
                Measurement methodMeasurement = method.getAnnotation(Measurement.class);
                if(methodMeasurement != null){
                    interations = methodMeasurement.iterations();
                    group = methodMeasurement.group();
                }
                runCase(bCase,method,interations,group);
            }
        }
    }
    private void runCase(Case bCase, Method method,int interations, int group) throws InvocationTargetException, IllegalAccessException {
        System.out.println(method.getName());
        for (int i = 0; i < group; i++) {
            System.out.printf("第%d次试验：",i);
            long t1 = System.nanoTime();
            for (int j = 0; j < interations; j++) {
                method.invoke(bCase);
            }
            long t2 = System.nanoTime();
            System.out.printf("耗时%d纳秒%n",t2-t1);
        }
    }
}

public class CaseLoader {
    public CaseRunner load() throws Exception {
        //包名称
        String pkgDot = "com.irilia.cases";
        //路径名称
        String pkg = "com/irilia/cases";
        List<String> classNameList = new ArrayList<String>();

        //1.根据一个固定的类找到类加载器
        ClassLoader loader = this.getClass().getClassLoader();
        //2.根据加载器找到类文件所在的路径
        Enumeration<URL> urls = loader.getResources(pkg);
        //3.扫描路径的所有类文件
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            if(url.getProtocol().equals("file")){
                //TODO:如果不是*.class文件，暂时不支持此功能
                //扩展功能：如何从jar包中加载文件
                continue;
            }
            //URL解码要转换：URLDecoder.decode
            String dirname = URLDecoder.decode(url.getPath(),"UTF-8");
            File dir = new File(dirname);
            //如果dir不是目录,判断下一个
            if(!dir.isDirectory()){
                continue;
            }
            //扫描该目录下的所有*.class文件，作为所有的类文件
            File[] files = dir.listFiles();
            if(files == null){
                continue;
            }
            for(File file : files){
                //TODO:漏洞：没有判断后轴是否是.class
                String fileName = file.getName();
                String className = fileName.substring(0,fileName.length()-6);
                classNameList.add(className);
            }
        }
        List<Case> caseList = new ArrayList<Case>();
        for(String className : classNameList){
            //1.先根据反射得到类的实例
            Class<?> cls = Class.forName(pkgDot+"."+className);
            if(hasInterface(cls,Case.class)){
                //如果有这个Case接口，说明是我们想要的，将这个Case加入到Case的List集合中
                caseList.add((Case)cls.newInstance());
            }
        }
        return new CaseRunner(caseList);
    }
    private boolean hasInterface(Class<?> cls,Class<?> intf){
        Class<?>[] intefs = cls.getInterfaces();
        for(Class<?> i : intefs){
            if(i == intf) {
                return true;
            }
        }
        return false;
    }
}
