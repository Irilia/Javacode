package ListTest;

import java.util.ArrayList;
import java.util.List;
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(3));
        System.out.println(list.get(1));
        System.out.println(list.set(1,7));
        System.out.println(list.get(1));
        System.out.println(list.remove(2));
        System.out.println(list);
        System.out.println(list.remove(new Integer(4)));
        System.out.println(list);
    }
}
