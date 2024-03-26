package org.arraylist;

import java.util.*;

public class ListIteratorCollection {
    public static void main(String[] args) {
        // Collection<E>를 구현하는 클래스 인스턴스 -> iterator 호출 가능
        // List<E> 구현 클래스 -> 양방향 반복자
        // public ListIterator<E> listIterator()
        // 양방향 반복자: 양쪽 방향으로 이동이 가능한 반복자

        List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
        list = new ArrayList<>(list);

        ListIterator<String> strItr = list.listIterator();

        String str;

        while (strItr.hasNext()) {
            str = strItr.next();
            System.out.println(str + '\t');
            if (str.equals("Toy")) {
                strItr.add("Toy2"); // Toy 만나면, Toy2 저장
            }
        }
        System.out.println();

        while (strItr.hasPrevious()) {
            str = strItr.previous();
            System.out.println(str + '\t');
            if (str.equals("Robot")) {
                strItr.add("Robot2"); // Robot 만나면 Robot2 저장
            }
        }
        System.out.println();

        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next() + '\t');
        }
        System.out.println();
    }
}
