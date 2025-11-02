package org.betterwaytocreatethread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            return sum;
        };

        ExecutorService exr = Executors.newSingleThreadExecutor();
        // Future 타입 인자는 Callable 의 타입 인자와 일치시켜야 한다.
        Future<Integer> future = exr.submit(task); // 작업을 전달하고 결과를 받을 수 있는 Future 객체를 반환한다.

        Integer result = future.get();
        System.out.println("result = " + result);
        exr.shutdown();
    }
}

/*
 * Runnable 에 위치한 추상 메소드 run() 은 반환값이 없다.
 * Callable 인터페이스를 기반으로 작업을 구성하면 작업의 끝에서 반환하는 것이 가능하다.
 *  
 */