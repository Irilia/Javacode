package ListTest;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("ArrayList");
        list.add("hello");

        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.set(2,"你好"));
        System.out.println(list.get(2));
    }
}
