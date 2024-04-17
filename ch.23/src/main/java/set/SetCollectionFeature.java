package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetCollectionFeature {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set);
        System.out.println();
        set.add("Toy");
        set.add("Robot");
        set.add("Box");
        set.add("Robot");
        System.out.println("인스턴수 수 = " + set.size());
        System.out.println(set);

        // 반복자를 이용한 전체 출력
        for (Iterator<String> itr = set.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next() + '\t');
        }
        System.out.println();

        for (String s : set) {
            System.out.println(s + '\t');
        }
        System.out.println();
    }
}
