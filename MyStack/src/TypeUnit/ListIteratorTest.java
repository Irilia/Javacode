package TypeUnit;

import java.util.*;

public class ListIteratorTest {
    public static void main(String[] args) {
        Vector<String> list = new Vector<>();
        //List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("bit");
        //迭代输出
        //Iterator<String> iterator = list.iterator();
        //ListIterator继承了Iterator接口
        /*ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("--------");
        while(iterator.hasPrevious()){
            String str = iterator.previous();
            System.out.println(str);
        }*/
        Enumeration<String> enumeration = list.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
            //迭代输出的过程中添加时会出现死循环
            //删除时会出现异常
            //list.add("wo");
        }
    }
    //fail-fast
    public static int div(int a,int b) {
        if(b==0){
            throw new IllegalArgumentException("除数不能为0");
        }
        return a / b;
    }
}
