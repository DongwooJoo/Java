package sort;

import java.util.*;

// 1. sort() - Comparable<T>
// Collections 클래스의 sort() 메서드를 사용한다.
// public static <T extends Comparable<T>> void sort(List<T> list)
public class SortCollections {
    public static void main(String[] args) {
        List<String> family = Arrays.asList("기역", "디귿", "니은", "리을");
        family = new ArrayList<>(family);

        // 정렬 이전 출력
        for (Iterator itr = family.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next() + "\t");
        }

        System.out.println("--------------------------");

        // 정렬하기
        Collections.sort(family); // family의 타입 파라미터는 String 이다. String 클래스는 Comparable<String>을 구현하고 있으므로, Collections.sort() 메서드를 사용할 수 있다.

        // 정렬 출력
        for (Iterator itr = family.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next() + "\t");
        }
        System.out.println();

        // String 클래스의 Comparable<String> 구현 알고리즘은 "사전 편찬 순(lexicographically)" 이다.
        // 가나다라, abcd 순서대로 이다.
    }
}

// public static <T extends Comparable<? super T>> void sort(List<T> list) {
//     list.sort(null);
// }

// 해석해보자.
// 1. public static <T> void sort(List<T> list) {...} 로 줄이자.
// -> List<T> 인스턴스는 모두 인자로 올 수 있다.
// 2. <T extends Comparable<? super T>>
// -> T는 Comparable<T> 인터페이스를 구현해야 한다.
// -> 타입 파라미터는 T를 상속해야 한다.