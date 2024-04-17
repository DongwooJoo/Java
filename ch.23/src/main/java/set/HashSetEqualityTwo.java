package set;

import java.util.HashSet;

public class HashSetEqualityTwo {
    public static void main(String[] args) {
        HashSet<Nums> set = new HashSet<>();
        set.add(new Nums(7799));
        set.add(new Nums(9955));
        set.add(new Nums(7799));
        System.out.println("인스턴수 수: " + set.size());

        for (Nums n : set) {
            System.out.println(n.toString() + '\t');
        }
        System.out.println();
    }
}

class Nums {
    private int num;
    public Nums(int n) {
        num = n;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

//    @Override
//    public int hashCode() {
//        return num % 3;
//    }

    @Override
    public boolean equals(Object obj) {
        if (num == ((Nums) obj).num) {
            return true;
        } else {
            return false;
        }
    }
}
