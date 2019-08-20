package com.irilia;

import com.irilia.annotations.BenchMark;
import com.irilia.annotations.Measurement;
import com.irilia.annotations.WarmUp;
import com.irilia.cases.Cases;
import jdk.internal.dynalink.beans.StaticClass;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private List<Cases> caseList;

    public CaseRunner(List<Cases> caseList){
        this.caseList = caseList;
    }
    //指定配置选项
    //TODO：没有吧Warmup预热考虑进来，每组实验之前都应该预热
    public void run(List<String[]> list,HSSFRow row,HSSFSheet sheet) throws InvocationTargetException, IllegalAccessException, FileNotFoundException {
        //运行：一个一个运行
        int interations = DEFAULT_ITERATIONS;
        int group = DEFAULT_GROUP;


        for(Cases bCase:caseList){
                //找到对象中哪些方法是需要测试的方法，哪些是不需要测试的方法
                //找到所有的方法，看方法中有没有包含Benchmark注解
                //1.得到所有的方法

                Method[] methods = bCase.getClass().getMethods();
                for(Method method: methods){
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

                    runCase(bCase,method,interations,group,list);

                    for(int a = 0;a < list.size();a++){
                        //拿到列表中的元素：数组，一个数组记录了一组结果
                        row = sheet.createRow(a + 1);
                        //拿到了一个list元素，将这个元素内容换成数组
                        String[] tmp = list.get(a);
                        for (int i = 0; i < tmp.length; i++) {
                            //在这一行中新建列来存放数组元素
                            row.createCell(i).setCellValue(tmp[i]);
                        }
                    }
                }

        }


    }

    public static void runCase(Cases bCase, Method method, int interations,
                               int group,List<String[]> list)
            throws InvocationTargetException, IllegalAccessException {
        //进行预热
        int warm=1000 ;
        WarmUp warmup=method.getAnnotation(WarmUp.class);
        if(warmup!=null){
            warm=warmup.iterations();
        }
        for(int w=0;w<warm;w++){
            method.invoke(bCase);
        }


        //cell.setCellValue(method.getName());

        System.out.println(method.getName());

        for (int i = 1; i <= group; i++) {

            int x= 0;
            String[] value = new String[group];
            value[x] = method.getName();

            System.out.printf("第%d次试验：",i);
            value[++x] = "第"+i+"次实验";
            long t1 = System.nanoTime();
            for (int j = 0; j < interations; j++) {
                //反射
                method.invoke(bCase);
            }
            long t2 = System.nanoTime();
            System.out.printf("耗时%d纳秒%n",t2-t1);
            value[++x] = "耗时"+(t2-t1)+"纳秒";
            list.add(value);
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
        Enumeration<URL> urls =  loader.getResources(pkg);
        //3.扫描路径的所有类文件
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            //System.out.println(url.getPath());
            if(!url.getProtocol().equals("file")){
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
        List<Cases> caseList = new ArrayList<Cases>();
        for(String className : classNameList){
            //1.先根据反射得到类的实例
            Class<?> cls = Class.forName(pkgDot+"."+className);
            if(hasInterface(cls, Cases.class)){
                //如果有这个Case接口，说明是我们想要的，将这个Case加入到Case的List集合中
                caseList.add((Cases)cls.newInstance());
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
