package org.betterwaytocreatethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo2 {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + (5 + 7));
        };
        Runnable task2 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + (7 - 5));
        };

        // 1개의 쓰레드가 있는 쓰레드 풀을 생성하고 유지
        ExecutorService exr = Executors.newSingleThreadExecutor();
        exr.submit(task1); // 쓰레드 풀에 작업 전달
        exr.submit(task2); // 쓰레드 풀에 작업 전달

        // 2개의 쓰레드가 있는 쓰레드 풀을 생성하고 유지
        ExecutorService exr2 = Executors.newFixedThreadPool(2);
        exr2.submit(task1); // 쓰레드 풀에 작업 전달
        exr2.submit(task2); // 쓰레드 풀에 작업 전달

        // 필요한 만큼의 쓰레드를 생성하고 작업이 끝나면 쓰레드를 종료
        ExecutorService exr3 = Executors.newCachedThreadPool();
        exr3.submit(task1); // 쓰레드 풀에 작업 전달
        exr3.submit(task2); // 쓰레드 풀에 작업 전달
        exr3.submit(() -> { // 반복해서 시킬 작업이 아니면 익명 클래스를 람다표현식으로 작성하는 것이 좋다.
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + (5 * 7));
        });

        // 쓰레드 풀과 그 안에 있는 쓰레드의 소멸. 이 메소드가 호출되어도 이미 전달된 작업은 진행이 된다.
        // 다만 추가로 작업을 전달받지는 않는다.
        exr.shutdown();
        exr2.shutdown();
        exr3.shutdown();
    }
}
