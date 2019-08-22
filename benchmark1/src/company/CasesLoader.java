package company;




import annotions.Benchmark;
import annotions.Measurement;
import annotions.Warmup;
import cases.Cases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

//运行
class CasesRunner{
    private static final int DEFAULT_ITERATIONS=10;//默认配置
    private static final int DEFAULT_GROUP=5;
    private  List<Cases> casesList;

    public CasesRunner(List<Cases> casesList) {
        this.casesList = casesList;
    }

    public void run() throws InvocationTargetException, IllegalAccessException {
        for(Cases bCases:casesList){
            int iterations=DEFAULT_ITERATIONS;
            int group=DEFAULT_GROUP;
            //先获取类级别的配置
            Measurement classMeasurement=bCases.getClass().getAnnotation(Measurement.class);
            if(classMeasurement!=null){
                //表示配置了
                iterations=classMeasurement.iterations();
                group=classMeasurement.group();
            }
            //找到对象中哪些方法是需要测似的方法
            Method[] methods=bCases.getClass().getMethods();
            for(Method method:methods){
                //找到benchmark标注的方法
                Benchmark benchmark=method.getAnnotation(Benchmark.class);
                if (benchmark==null){
                    continue;
                }

                Measurement methodMeasurement=method.getAnnotation(Measurement.class);
                if(methodMeasurement!=null){
                    iterations=methodMeasurement.iterations();
                    group=methodMeasurement.group();
                }
                runCase(bCases,method,iterations,group);
            }
        }
    }
    public static  void runCase(Cases bCases,Method method,int iterations,int group) throws InvocationTargetException, IllegalAccessException {
        System.out.println(method.getName());
        //进行预热
        int warm=100 ;
        Warmup warmup=method.getAnnotation(Warmup.class);
        if(warmup!=null){
            warm=warmup.iterations();
        }

        for(int w=0;w<warm;w++){
            method.invoke(bCases);
        }

        for (int i=0;i<group;i++){
            System.out.printf("%d次实验,",i+1);
            long t1=System.nanoTime();
            for (int j=0;j<iterations;j++){
                method.invoke(bCases);
            }
            long t2=System.nanoTime();
            System.out.printf("cost %d 纳秒 %n",t2-t1);
        }
    }
}
public class CasesLoader {
    public CasesRunner load() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String pkg = "benchmark1/cases";//在此包下加载所有的类
        String pkgDot = "benchmark1.cases";


        List<String> classNameList = new ArrayList<>();//保存类的名称
        //根据一个固定类，找到类加载器
        //根据加载器找到类文件所在路径
        //扫描路径的所有文件
        ClassLoader classLoader = this.getClass().getClassLoader();
        Enumeration<URL> urls = classLoader.getResources(pkg);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            if (!url.getProtocol().equals("file")) {//获取协议名称
                //如果不是*.class文件，暂时不支持
                continue;
            }
            String pathname = URLDecoder.decode(url.getPath(), "UTF-8");//做url解码
            File path = new File(pathname);
            if (!path.isDirectory()) {//不是目录的话 继续进行
                continue;
            }
            //扫描该目录下的所有*.class文件，作为所有类的文件
            File[] files = path.listFiles();
            if (files == null) {
                continue;
            }
            for (File file : files) {
                //TODO 没有判断后缀是否是.class
                String filename = file.getName();
                String className = filename.substring(0, filename.length()-6);
                classNameList.add(className);//得到所有的类的名称
            }
        }
        List<Cases> caseList = new ArrayList<Cases>();
        for (String className : classNameList) {
            Class<?> cls = Class.forName(pkgDot + "." + className);
            //判断是否Cases类
            if (hasInterface(cls, Cases.class)) {
                caseList.add((Cases) cls.newInstance());
            }
        }
        return new CasesRunner(caseList);

    }
    private boolean hasInterface(Class<?> cls,Class<?> intf){
        Class<?>[] intfs=cls.getInterfaces();//获取接口
        for(Class<?> i:intfs){
            if(i==intf) return true;
        }return false;
    }

}
