package map;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class AgeComparator implements Comparator<Integer> {
// Comparator<T> 에서 T == Integer 인 이유는 map.key 의 타입이 Integer 이기 때문이다.
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public class ComparatorTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());
        map.put(45, "dong");
        map.put(35, "woo");
        map.put(25, "joo");
        //
        Set<Integer> keySet = map.keySet();
        //
        for (Integer n : keySet) {
            System.out.println(n.toString() + '\t');
        }
        System.out.println();

        for (Integer n : keySet) {
            System.out.println(map.get(n));
        }
        System.out.println();

        for (Iterator<Integer> itr = keySet.iterator(); itr.hasNext(); ) {
            System.out.println(map.get(itr.next()) + '\t');
        }
        System.out.println();
    }

}
