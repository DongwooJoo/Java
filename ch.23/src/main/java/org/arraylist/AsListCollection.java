package org.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AsListCollection {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toy", "Robot", "Box", "Robot");
        list = new ArrayList<>(list);

        // for문 기반의 반복자 획득과 순차적 참조
        for (Iterator<String> iterator1 = list.iterator(); iterator1.hasNext(); ) {
            System.out.println(iterator1.next() + '\t');
        }
        System.out.println();

        // "Robot"을 삭제하기 위한 반복문
        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            if (itr.next().equals("Robot")) {
                itr.remove();
            }
        }

        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next() + '\t');
        }
        System.out.println();

    }
}
