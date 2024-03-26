package org.arraylist;

import java.util.*;

public class ConversionCollection {
    public static void main(String[] args) {
        // 대다수 컬렉션 클래스들은 다른 컬렉션 인스턴스를 인자로 전달받는 생성자를 갖는다.
        // 다른 컬렉션 인스턴스 데이터 -> 복사해서 새로운 컬렉션 인스턴스로 생성할 수 있다.

        List<String> list = Arrays.asList("Toy", "Robot", "Box", "Robot");
        list = new ArrayList<>(list);

        // ArrayList 인스턴스의 순환
        for (Iterator<String> itr = list.iterator(); itr.hasNext();) {
            System.out.println(itr.next() + '\t');
        }
        System.out.println();

        // ArrayList 인스턴스 기반으로 LinkedList<E> 인스턴스 생성
        list = new LinkedList<>(list);

        System.out.println("--------------------");
        System.out.println("LinkedList");
        // LinkedList 인스턴스의 순환
        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next() + '\t');
        }
        System.out.println();
    }
}
