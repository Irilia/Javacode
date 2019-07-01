package TypeUnit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("hello");
        list.add("java");

        System.out.println(list.size());
    }
}
