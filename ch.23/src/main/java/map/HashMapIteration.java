package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapIteration {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "woo");
        map.put(35, "joo");
        map.put(12, "dong");
        // key 만 담는 컬렉션 인스턴스 생성
        System.out.println(map);
        System.out.println();
        Set<Integer> keySet = map.keySet();

        // 전체 key 출력 (for-each 문 기반)
        for (Integer n : keySet) {
            System.out.println("key: " + n.toString() + '\t');
        }
        System.out.println();

        for (Integer n : keySet) {
            System.out.println("value: " + map.get(n).toString() + '\t');
        }
        System.out.println();

        for (Iterator<Integer> itr = keySet.iterator(); itr.hasNext(); ) {
            System.out.println("itr value: " + map.get(itr.next()) + '\t');
        }
    }
}
// 핵심은 HashMap.keySet() 이다.
// Set<E> extends Collection<E> extends Iterable<E> 이기 때문에, 반복자를 시용할 수 있다.