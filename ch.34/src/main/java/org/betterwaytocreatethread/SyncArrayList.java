package org.betterwaytocreatethread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SyncArrayList {
    public static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        System.out.println(list);

        Runnable task = () -> {
            // list 컬렉션이 동기화 되었다고 해도, 반복자도 동기화되는 것은 아니다.
            // 따라서 반복자도 동기화를 해주어야 한다.
            synchronized (list) { // 이 영역 실행 시 list에 다른 쓰레드 접근 불가.
                ListIterator<Integer> itr = list.listIterator();
                while (itr.hasNext()) {
                    itr.set(itr.next() + 1);
                }
            }
        };
        
        ExecutorService exr = Executors.newFixedThreadPool(3);
        exr.submit(task);
        exr.submit(task);
        exr.submit(task);

        exr.shutdown();
        exr.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println(list);
    }

}

/**
 * 동기화는 특성상 성능의 저하를 수반한다.
 * 따라서 불필요하게 동기화를 진행하지 않도록 주의해야 한다.
 * 이런 이유로 컬렉션 프레임워크의 클래스 대부분도 동기화 처리가 되어있지 않다.
 * 따라서 쓰레드의 동시 접근에 안전하지 않다.
 * 대신 Collections 의 다음 메소드들을 통한 동기화 방법을 제공하고 있다.
 * 
 * public static <T> Set<T> synchronizedSet(Set<T> s)
 * public static <T> List<T> synchronizedList(List<T> l)
 * public static <K,V> Map<K,V> synchronizedMap(Map<K,V> m)
 * public static <T> Collection<T> synchronizedCollection(Collection<T> c)
 * 
 * 동기화 방법은 간단하다. ArrayList<String> 인스턴스를 쓰레드의 동시 접근에 안전한 상태가 되게 하려면 다음과 같이 코드를 작성하면 된다.
 * List<String> list = Collections.synchronizedList(new ArrayList<String>());
 */