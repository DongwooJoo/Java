package set;

import java.util.Comparator;
import java.util.TreeSet;

class IntegerComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}

public class ComparatorInteger {
    public static void main(String[] args) {
        TreeSet<Integer> tr = new TreeSet<>(new IntegerComparator());
        tr.add(30);
        tr.add(10);
        tr.add(20);
        IntegerComparator integerComparator = new IntegerComparator();

        System.out.println(integerComparator);
        System.out.println(System.identityHashCode(integerComparator)); // 해시 코드
        System.out.println(tr);
    }
}

