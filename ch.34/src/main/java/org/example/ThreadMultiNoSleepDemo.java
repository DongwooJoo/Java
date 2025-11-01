package org.example;

public class ThreadMultiNoSleepDemo {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is even");
                }
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 1) {
                    System.out.println(i + " is odd");
                }
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
    }

}
