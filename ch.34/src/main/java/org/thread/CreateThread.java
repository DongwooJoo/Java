package org.thread;

import java.util.Arrays;

public class CreateThread {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        // 배열의 길이가 10인 문자열 배열 생성
        String[] arr = new String[10];
        // 배열에 Thread 1~10 까지 채우기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "Thread " + (i + 1);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("현재 쓰레드 이름 = " + name);
    }
}
