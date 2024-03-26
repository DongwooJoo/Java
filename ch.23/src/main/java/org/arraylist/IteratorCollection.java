package org.arraylist;

import java.util.*;

public class IteratorCollection {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        list.add("Toy");
        list.add("Box");
        list.add("Robot");
        list.add("Box");

        Iterator<String> iterator = list.iterator(); // 반복자 생성

        // 반복자를 이용한 순차적 참조
        while (iterator.hasNext()) { // next가 있는지 체크한다. 왜? 반환할 인스턴스가 없으면 NoSuchElementException 에러를 발생시킨다.
            System.out.println(iterator.next());
        }
        System.out.println("--------------------------------");

        iterator = list.iterator();

        // 모든 box 삭제
        String str;
        while (iterator.hasNext()) {
            str = iterator.next();
            if (str.equals("Box")) {
                iterator.remove();
            }
        }

        iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + '\t');
        }
        System.out.println();


        // for-each 문도 컴파일 과정에서 반복자를 이용하는 코드로 수정된다.
        // 즉, for-each 문 역시 반복자에 의한 순차적 접근으로 진행이 된다.
        for (String s : list) {
            System.out.println(s + '\t');
        }

        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next() + '\t');
        }

        List<String> arrayToArrayList = Arrays.asList("Toy", "Robot", "Box");
        System.out.println(arrayToArrayList);
    }
}
