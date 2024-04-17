package set;

import java.util.Comparator;
import java.util.TreeSet;

class StringComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}
public class ComparatorString {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<>(new StringComparator());
        tree.add("Robot");
        tree.add("robot");
        tree.add("roBot");
        tree.add("Robot2");
        tree.add("Box");
        tree.add("Donut");

        for (String s : tree) {
            System.out.println(s.toString() + '\t');
        }
    }
}

// key
// 1. String 클래스의 경우, 사전 편찬 순으로 정렬되도록 정의되어 있음
// Comparator<String>을 구현하는 함수가 정의되어 있음.
// 2. 새로운 정렬기준을 구현할 수 있음.
// StringComparator 클래스를 만들고, Comparator<T>를 implements 하면 됨.

// 메소드 오버라이딩 @Override
// 상위 클래스에 정의된 메소드를 하위 클래스에서 다시 정의하는 것