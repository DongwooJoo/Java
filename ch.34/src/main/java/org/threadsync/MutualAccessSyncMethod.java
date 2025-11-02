package org.threadsync;

public class MutualAccessSyncMethod {

    public static Counter1 cnt = new Counter1();

    public static void main(String[] args) throws InterruptedException {
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
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cnt.getCount1());
    }
}

class Counter1 {
    int count1 = 0; // 두 쓰레드에 의해 공유되는 변수

    public synchronized void increment() {
        count1++; // 첫번째 쓰레드에 의해 실행되는 문장
    }

    public synchronized void decrement() {
        count1--; // 두번째 쓰레드에 의해 실행되는 문장
    }

    public int getCount1() {
        return count1;
    }

}


/*
 * increment(), decrement() 메서드에 synchronized 키워드를 붙이고 실행하면 동시성 문제가 해결된다.
 * synchronized 선언이 추가되면, 이 메소드는 한순간에 한 쓰레드의 접근만을 허용하게 된다.
 * 
 * 예를 들어서 이 메소드를 두 쓰레드가 동시에 호출하면,
 * 1. 조금이라도 빨리 호출한 쓰레드가 메소드를 실행하게 되고
 * 2. 다른 한 쓰레드는 대기하고 있다가 먼저 호출한 쓰레드가 실행을 마쳐야 비로소 메소드를 실행하게 된다. (동기화)
 * 
 * 이와 같이 '한 클래스의 두 메소드'에 synchronized 선언이 되면, 두 메소드는 둘 이상의 쓰레드에 의해 동시에 실행될 수 없도록 동기화된다.
 * 예를 들어서 한 쓰레드가 increment() 메소드를 실행하는 중간에 다른 쓰레드가 decrement() 메소드를 호출하면,
 * 이 쓰레드는 increment() 메소드의 호출이 완료될 때까지 대기하게 된다.
 */