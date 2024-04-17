package set;

import java.util.HashSet;

public class HashSetEqualityOne {
    public static void main(String[] args) {
        HashSet<Nums> set = new HashSet<>();
        Nums a = new Nums(7799);
        Nums b = new Nums(7799);
        Nums c = new Nums(7799);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println(a.toString());

        System.out.println();
        System.out.println(set);
        set.add(new Nums(7799));
        set.add(new Nums(9955));
        set.add(new Nums(7799));

        System.out.println();
        System.out.println(set);
        System.out.println("인스턴수 수 = " + set.size());

        for (Nums n : set) {
            System.out.println(n.toString() + '\t');
        }
        System.out.println();
        System.out.println(set);
    }
}

class Num {
    private int num;

    public Num(int n) {
        num = n;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }


}