package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConvertCollection {
    // 중복된 인스턴스 제거
    // 1. 기존 Arraylist를 set에 넣는다.
    // 2. set을 ArrayList에 다시 넣는다.

    public static void main(String[] args) {
        List<String> lst = Arrays.asList("Box", "Toy", "Robot", "Toy");
        ArrayList<String> list = new ArrayList<>(lst);

        for (String s : list) {
            System.out.println(s.toString() + '\t');
        }
        System.out.println();

        HashSet<String> set = new HashSet<>(list);
        // public HashSet(Collection<? extends E> c);
        // -> new HashSet(ArrayList<String> list);

        //    public HashSet(Collection<? extends E> c) {
        //        map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        //        addAll(c);
        //    }

        list = new ArrayList<>(set);

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

    }
}
