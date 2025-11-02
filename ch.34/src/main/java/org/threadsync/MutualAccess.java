package org.threadsync;

public class MutualAccess {
    public static Counter cnt = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.increment(); // task 1에서는 값을 1 증가
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.decrement(); // task 2에서는 값을 1 감소
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start(); // task 1 실행
        t2.start(); // task 2 실행
        t1.join(); // task 1 종료 대기.
        t2.join(); // task 2 종료 대기
        System.out.println(cnt.getCount()); // 결과 출력
    }
}

class Counter {
    int count = 0; // 두 쓰레드에 의해 공유되는 변수

    public void increment() {
        count++; // 첫번째 쓰레드에 의해 실행되는 문장
    }
    public void decrement() {
        count--; // 두번째 쓰레드에 의해 실행되는 문장
    }

    public int getCount() {
        return count;
    }
}

/*
 * join() 메서드는 해당 쓰레드가 종료될 때까지 대기한다.
 * 이 메서드는 쓰레드가 종료될 때까지 대기하므로, 쓰레드가 종료된 후에 결과를 출력할 수 있다.
 * 
 * main 쓰레드가 두 쓰레드의 실행이 완료되기를 기다리기 위해서 join 메서드를 사용했다.
 * 실행결과를 예상해보면, 첫번째 쓰레드는 increment() 메서드를 1000번 호출하고, 두번째 쓰레드는 decrement() 메서드를
 * 1000번 호출하여야 한다.
 * 따라서, 출력결과는 0이 되어야 한다.
 * 하지만 실행할 때마다 출력 결과가 다르다.
 * 
 * 이는 두 쓰레드가 동시에 count 변수를 증가 또는 감소시키기 때문이다.
 * 둘 이상의 쓰레드가 동일한 변수에 접근하면 변수의 값이 예상과 다르게 변경될 수 있다.
 * 이러한 문제를 해결하기 위해서 동기화(synchronization)를 사용해야 한다.
 * 
 * 동기화란 무슨 뜻인가?
 * 두 개 이상의 시스템, 기기 또는 작업이 동일한 데이터를 공유하고 일치시키거나, 서로의 상태나 실행 시점을 조율하는 과정이다.
 * 만약 내 맥북과 아이패드에서 메모 앱을 사용하고 있는데 기기 간 메모 앱의 데이터가 동기화가 되지 않는다면 기기 간 다른 메모들이 저장될
 * 것이다.
 * 동기화가 되면 어느 기기를 사용하든 간에 메모 앱을 동일한 메모들을 가질 것이다.
 * 
 * 쓰레드에서 동기화는 둘 이상의 쓰레드가 동일한 메모리 공간에 접근해도 문제가 발생하지 않도록, 데이터를 일치시켜주는 작업이다.
 * 그런데 동일한 메모리에 접근하면 왜 문제가 발생할까?
 * 동일한 메모리에 접근해서 저장된 변수를 참조하면 그게 왜 문제일까?
 * 
 * 좀 더 깊게 생각하면 지금 문제는, "동일한 메모리에 접근하는 것" 만이 아니다.
 * 진짜 문제는 동일한 메모리에 접근하면서 그 메모리에 저장된 변수를 "거의 동시에" 참조하는 것이다.
 * 
 * 즉, Thread 1과 Thread 2가 동일한 메모리에 있는 count 변수에 거의 동시에 접근하면서 문제가 발생한다.
 * 이러한 문제를 "동시성 문제" 라고 한다.
 * 
 * 자, 더 자세히 설명해보자.
 * 처음에 초기화된 count 변수의 값은 0이다.
 * 
 * 우리가 예상한 프로세스는 다음과 같을 것이다.
 * Thread 1 -> count 변수가 0일 때 참조해서 1로 증가
 * Thread 2 -> count 변수가 1일 때 참조해서 0으로 감소
 * ...(반복되는 과정)
 * 
 * 하지만 실제 프로세스는 다음과 같을 것이다.
 * 
 * Thread 1 -> count 변수가 0일 때 참조해서 1로 증가
 * Thread 2 -> count 변수가 0일 때 참조해서 -1로 감소
 * ...(예상 불가능한 결과가 발생하는 반복되는 과정)
 * 
 * 그래서 코드 실행 결과가 다음과 같다.
 * 첫 번째 실행 결과: -48
 * 두 번째 실행 결과: -206
 * 거의 동시에 변수를 참조하는데, 그 시점을 예상할 수 없어 문제가 발생한다.
 * 문제를 해결하기 위해서 동기화(synchronization)를 사용해보자.
 * 
 */