package map;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapIteration {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(2, "woo");
        map.put(1, "dong");
        map.put(3, "joo");
        //
        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            System.out.println("key: " + key);
        }
        System.out.println();

        for (Integer key : keySet) {
            System.out.println("value : " + map.get(key));
        }
        System.out.println();

        for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext(); ) {
            System.out.println(map.get(iterator.next()) + '\t');
        }
        System.out.println();
    }
}
