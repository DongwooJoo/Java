package set;

import java.util.TreeSet;

class Person implements Comparable<Person>{
    private String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.age; // 인자로 전달된 수가 더 크면 음수를 반환 -> Java에서 결정한 약속
    }

    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;
    }
}

public class ComparablePerson {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("Dong", 37));
        treeSet.add(new Person("Woo", 12));
        treeSet.add(new Person("Joo", 23));

        for (Person p : treeSet) {
            System.out.println(p);
        }
    }
}

// compareTo 함수 정의 방법. 올바르게 정렬하기 위한.
// 인자로 전달된 수가 더 크면 음수를 반환
// 인자로 전달된 수가 더 작으면 양수를 반환
// 인자로 전달된 수와 같으면 0을 반환