package org.arraylist;

import java.util.LinkedList;
import java.util.List;

public class EnhancedForCollection {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        // el 추가
        list.add("toy");
        list.add("robot");
        list.add("slicon");

        for (String s : list) {
            System.out.println(s + '\t');
        }
        System.out.println();

        // el 삭제
        list.remove(0);

        for (String s : list) {
            System.out.println(s + '\t');
        }
        System.out.println();
    }
}
