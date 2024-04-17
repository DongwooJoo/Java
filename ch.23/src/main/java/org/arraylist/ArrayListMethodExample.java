package org.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentSkipListSet;

public class ArrayListMethodExample {

    public static void main(String[] args) {
        //
        List<String> ufcFighterList = new ArrayList<>();

        List<String> stack = new Stack<>();
        ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();



        // 1. add
        ufcFighterList.add("justin gaethje");
        ufcFighterList.add("dustin poirier");
        ufcFighterList.add("jon jones");
        System.out.println(ufcFighterList);
        System.out.println("---------------");

        // 2. get
        // ufc fighter 목록을 1명씩 리턴한다.
        for (int i=0; i < ufcFighterList.size(); i++) {
            System.out.println(ufcFighterList.get(i));
        }
        System.out.println("---------------");

        // 3. add
        // ufc fighter을 list 마지막에 추가한다.
        ufcFighterList.add("chansung Jung");
        System.out.println(ufcFighterList);
        System.out.println("---------------");

        // 4. subList
        List<String> fighterSubList = ufcFighterList.subList(0, 3);
        System.out.println(fighterSubList);
        System.out.println("---------------");

        // 5. remove
//        String string = new String("string");
//        ufcFighterList.add(0, string);
//        fighterSubList.remove(0);
        ufcFighterList.remove(0);
        System.out.println(ufcFighterList);
        System.out.println(fighterSubList);
        System.out.println("---------------");
    }
}
