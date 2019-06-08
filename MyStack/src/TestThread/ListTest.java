package TestThread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.contains(1));
        System.out.println(list.get(2));
        System.out.println(list.remove(3));
        System.out.println(list.remove(new Integer(1)));
        System.out.println(list);
    }


}
