package org.betterwaytocreatethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MutualAccessReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Counter3 cnt = new Counter3();
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.increment();
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.decrement();
            }
        };
        ExecutorService exr = Executors.newFixedThreadPool(2);
        exr.submit(task1);
        exr.submit(task2);

        exr.shutdown();
        exr.awaitTermination(100, TimeUnit.SECONDS); // 쓰레드 풀에 전달된 작업이 끝나기를 100초간 기다린다.
        System.out.println("count3: " + cnt.getCount3());
    }
}

class Counter3 {
    int count3 = 0;
    ReentrantLock criticObj = new ReentrantLock();

    public void increment() {
        criticObj.lock(); // 문을 잠근다.
        // 한 쓰레드에 의해서만 실행되는 영역
        try {
            count3++;
            System.out.println("increment");
        } finally {
            criticObj.unlock(); // 문을 연다.
            // finally 블록을 사용한 이유는, lock() 메소드를 호출한 쓰레드가 unlock 메소드를 호출하지 않는 코드 상의 실수가 발생할 수 있기 때문이다.
        }
    }

    public void decrement() {
        criticObj.lock();
        try {
            count3--;
            System.out.println("decrement");
        } finally {
            criticObj.unlock();
        }
    }

    public int getCount3() {
        return count3;
    }
}

/**
 * 자바 5에서는 동기화 블록과 동기화 메소드를 대신할 수 있는 ReentrantLock 클래스를 제공한다.
 * 생각과 달리 shutdown 메소드는 바로 반환이 된다.
 * 즉, 쓰레드 풀에 전달된 작업이 마무리 되면 풀을 폐쇄하라고 명령을 할 뿐 기다려주지는 않는다.
 * 그래서 쓰레드 풀에 전달된 작업의 최종 결과를 확인하기 위해서는 awaitTermination 메소드를 사용해야 한다.
 * awaitTermination 메소드의 호출은 블로킹 상태(반환하지 않은) 놓이게 되어, 다음 두 가지 중 한 가지 상황에 이르러야
 * 메소드를 빠져나오게 된다.
 * - 쓰레드 풀에 전달된 작업이 모두 완료되었을 때
 * - 지정된 시간이 경과했을 때
 * 
 * 블로킹이란? 어떤 작업이 끝날 때까지 현재 쓰레드가 기다리는 상태를 의미한다.
 * awaitTermination 메소드로 블로킹이 되는 중에는 awaitTermination 메소드의 다음 줄 코드를 실행하지 않는다.
 * CPU가 멈추는 것은 아니다. 다른 스레드는 여전히 실행 가능하다.
 * 
 * shutdown(), awaitTermination() 메소드의 차이
 * - shutdown(): 쓰레드 풀에 전달된 작업이 마무리 되면 풀을 폐쇄하라고 명령을 할 뿐 기다려주지는 않는다.
 * - awaitTermination(): 쓰레드 풀에 전달된 작업이 모두 완료되었을 때 또는 지정된 시간이 경과했을 때 메소드를 빠져나온다(다음 코드를 실행한다).
 */