package org.threadsync;

public class MutualAccessSyncBlock {

    public static void main(String[] args) throws InterruptedException {
        Counter2 cnt = new Counter2();
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
        System.out.println(cnt.getCount2());
    }
}

class Counter2 {
    int count2 = 0; // 두 쓰레드에 의해 공유되는 변수

    public void increment() {
        synchronized (this) {
            count2++;
        }
    }

    public void decrement() {
        synchronized (this) { // 동기화 블록
            count2--; // 동기화가 필요한 문장
        }
        System.out.println("count2: " + count2); // 동기화가 불필요한 문장
    }

    public int getCount2() {
        return count2;
    }
}

/**
 * 동기화 메소드 기반의 동기화는 사용하기는 편하지만 메소드 전체에 동기화를 걸어야 한다는 단점이 있다.
 * 메소드 전체에 동기화가 걸리면, 메소드가 동기화가 불필요한 부분 또한 다른 쓰레드의 접근을 막게 된다.
 * 메소드 내에서 특정 부분만을 동기화하고 싶다면, 동기화 블록을 사용할 수 있다.
 * this 의 의미: 이 인스턴스의 다른 동기화 블록과 더불어 동기화하겠다. 
 * 
 * Thread-safe 한가?
 * StringBuffer 는 Thread-safe 한 클래스이다.
 * 이는 StringBuffer 가 synchronized 키워드를 사용하여 동기화가 되어 있기 때문이다.
 * 
 * 반면에 ArrayList 는 Thread-safe 하지 않은 클래스이다.
 * ArrayList 클래스에는 Note that this implementation is not synchronized. 라고 적혀있다.
 * 이는 동기화되어 있지 않다는 것을 의미한다.
 * 따라서 ArrayList 인스턴스를 대상으로는 둘 이상의 쓰레드가 동시에 접근하는 코드를 만들면 안 된다.
 */