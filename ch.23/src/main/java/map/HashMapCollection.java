package map;

import java.util.HashMap;

public class HashMapCollection {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(); // key, value 모두 인스턴스 여야 한다.
        // 저장, 참조, 삭제 시, 오토 박싱과 오토 언박싱이 진행되어서,
        // key가 primitive type 처럼 보일 뿐이다.

        // 데이터 저장
        map.put(1, "Toy");
        map.put(2, "Box");
        map.put(3, "Robot");
        map.put(4, "Toy");

        // 데이터 탐색
        System.out.println("1번: " + map.get(1));
        System.out.println("2번: " + map.get(2));
        System.out.println("3번: " + map.get(3));
        System.out.println("4번: " + map.get(4));
        System.out.println();

        // 데이터 삭제
        map.remove(1);
        System.out.println("1번: " + map.get(1));
    }
}

// 1. Map: Key, Value로 구성된다.
// 2. Key는 중복될 수 없고, Value는 중복 가능하다.
// 3. HashMap, TreeMap이 있다.
// 차이점은 트리 자료구조를 기반으로 구현된 TreeMap은 "Key"의 정렬 상태를 유지하는데 있다.