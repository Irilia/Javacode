package TypeUnit;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("hello");
        set.add("java");
        System.out.println(set);
    }
}
