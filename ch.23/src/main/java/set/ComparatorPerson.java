package set;


import java.util.Comparator;
import java.util.TreeSet;

class PersonComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;
    }
}
// p1 > p2 양의 정수 반환
// p1 < p2 음의 정수 반환
// p1 == p2 0 반환


public class ComparatorPerson {
    public static void main(String[] args) {
        TreeSet<Person> tree = new TreeSet<>(new PersonComparator());
        tree.add(new Person("woo", 24));
        tree.add(new Person("dong", 12));
        tree.add(new Person("joo", 36));

        for (Person p : tree) {
            System.out.println(p);
        }
    }
}
// key
// 1. 특정 객체를 비교할 같은 클래스를 만들고
// 2. Comparator<T> 를 상속한다.
// 3. int compare(T o1, T o2)를 구현한다.