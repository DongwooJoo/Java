package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Car implements Comparable<Car> {
    protected int disp; // 배기량

    public Car(int d) {
        disp = d;
    }

    @Override
    public String toString() {
        return "cc: " + disp;
    }

    @Override
    public int compareTo(Car o) {
        return disp - o.disp;
    }
}

public class CarSortCollections {
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();
        list.add(new Car(1200));
        list.add(new Car(3000));
        list.add(new Car(1800));
        Collections.sort(list);

        for (Iterator<Car> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next().toString() + '\t');
        }
    }
}
// sort 메소드의 실행 순서
// 1. public static void sort(List<Car> list)
// List<Car> 인스턴스를 전달하며, sort 메소드를 호출할 때, T는 Car로 결정된다.
// 2. <T extends Comparable<? super T>> 구현
// Car는 Comparable<Car>를 구현한다. 따라서, 이 조건을 만족한다.



// Collections.sort() 분석
// public static <T extends Comparable<? super T>> void sort(List<T> list)
// 1.