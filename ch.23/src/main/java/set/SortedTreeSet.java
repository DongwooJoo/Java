package set;

import java.util.Iterator;
import java.util.TreeSet;

public class SortedTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        System.out.println("인스턴스 수: " + tree.size());

        for (Integer n : tree) System.out.println(n.toString() + '\t');
        System.out.println();

        for (Iterator<Integer> itr = tree.iterator(); itr.hasNext();)
            System.out.println(itr.next().toString() + '\t');
        System.out.println();
    }
}
