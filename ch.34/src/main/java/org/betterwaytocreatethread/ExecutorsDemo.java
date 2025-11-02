package org.betterwaytocreatethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        Runnable task1 = () -> { // 쓰레드에 시킬 작업
            int n1 = 10;
            int n2 = 20;
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + (n1 + n2));
        };

        ExecutorService exr = Executors.newSingleThreadExecutor(); // 쓰레드 풀 생성
        exr.submit(task1); // 쓰레드 풀에 작업을 전달

        System.out.println("End " + Thread.currentThread().getName());
        exr.shutdown(); // 쓰레드 풀과 그 안에 있는 쓰레드의 소멸
    }
}


/*
 * 쓰레드의 생성과 소멸은 그 자체로 시스템에 부담을 주는 일이다.
 * 따라서 처리해야 할 일이 있을 때마다 쓰레드를 생성하는 것은 성능의 저하로 이어질 수 있다.
 * 그래서 "쓰레드 풀(Thread Pool)"을 만들고, 그 안에 미리 제한된 수의 쓰레드를 생성해두고 이를 재활용하는 기술을 사용하자.
 * 쓰레드 풀의 모형은 쓰레드 집합(쓰레드 풀)을 만들고 그 안에 하나의 쓰레드를 꺼내서 작업을 할당하는 것이다.
 * 작업을 마친 쓰레드는 다시 풀에 돌아가 다음 작업을 처리할 수 있도록 한다.
 * 
 * 쓰레드
 * 1. 쓰레드 생성 비용
 * - os/java vm 이 새로운 쓰레드 컨텍스트를 만들고 스택 메모리를 할당해야 함
 * - 이 과정은 비용이 꽤 크고, 수천개가 되면 매우 느려짐
 * 
 * 2. 작업 끝나면 쓰레드 소멸
 * - 쓰레드를 재사용하지 않음 -> 다음 작업마다 또 쓰레드 생성
 * 
 * 쓰레드 풀
 * 1. 미리 정해진 쓰레드 개수를 생성
 * - OS/VM 스택 메모리 할당은 한 번만
 * 2. 쓰레드 재사용
 * - 작업 끝나도 쓰레드는 풀에서 살아있음 -> 다음 작업 바로 처리
 * 3. 작업 큐 사용
 * - 많은 작업을 큐에 넣고 풀의 쓰레드가 하나씩 꺼내 처리
 * 4. 동시에 처리할 수 있는 최대 작업 수 제어 가능
 * - CPU 코어 수나 IO 특성에 맞춰 최적화 가능
 * 
 * 쓰레드와 쓰레드 풀의 성능차이가 나는 이유
 * 1. 쓰레드 생성/소멸 오버헤드
 * new Thread() → 매번 생성/종료 → 비용 발생
 * Thread Pool → 이미 생성된 쓰레드 재사용 → 비용 없음
 * 
 * 2. 컨텍스트 스위칭 최소화
 * 쓰레드가 많아지면 OS가 컨텍스트 스위칭을 많이 해야 함
 * 풀에서는 쓰레드 수를 제한하고 재사용 스위칭 최적화
 * 
 * 3. 작업 큐 활용
 * Thread Pool은 작업 큐를 통해 스레드가 작업을 순차적으로 가져가서 처리
 * 무제한 new Thread()는 동시에 너무 많은 쓰레드 생성 -> 스케줄러가 뒤죽박죽 처리
 * 
 */
