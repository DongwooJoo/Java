package org.arraylist;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimitiveCollection {
    public static void main(String[] args) {
        // 컬렉션 인스턴스도 기본 자료형의 값은 저장 X
        // -> 래퍼 클래스로 저장 및 참조
        // 오토 박싱, 오토 언박싱 코드 구현

        LinkedList<Integer> list = new LinkedList<>();

        // 데이터 저장
        list.add(10);
        list.add(20);
        list.add(30);
        // 저장 과정에서 오토 박싱 진행
        System.out.println(list);
        System.out.println();

        int n;
        for (Iterator<Integer> itr = list.iterator(); itr.hasNext(); ) {
            // 반복자에서 next가 있으면, 아래 코드 실행
            n = itr.next(); // 오토 언박싱 진행
            System.out.println(n + "\t");
        }
        System.out.println();
    }
}
