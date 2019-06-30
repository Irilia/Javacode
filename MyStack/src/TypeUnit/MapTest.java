package TypeUnit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"java");
        map.put(3,"hello");
        map.put(4,"bit");
        map.put(4,"测试");
        System.out.println(map.get(4));
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> integerIterator = keySet.iterator();
        while(integerIterator.hasNext()) {
            Integer i = integerIterator.next();
            System.out.println(i+"="+map.get(i));
        }
    }
}
