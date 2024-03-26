package org.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        // List 인터페이스를 참조하는 이유: 코드의 유연성 제공. 주로 List 인터페이스에 있는 메소드를 호출한다.
        // List<E> 형 참조변수로 인스턴스를 참조할 겨우 컬렉션 클래스의 교체가 용이하다.

        list.add("Toy");
        list.add("Box");
        list.add("Robot"); // 인스턴스 추가

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + '\t');
        }
        System.out.println();
        // 실제 자료구조에 저장되는 것은 인스턴스의 참조 값이다.


        list.remove(0); // 인스턴스 삭제

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + '\t');
        }
        System.out.println();


        ArrayList<String> bigSizeList = new ArrayList<>(50000);
        System.out.println("big list size");
        System.out.println(bigSizeList.size());
    }
}