package org.array;

import java.util.Arrays;

public class InsertSort {
    // 삽입 정렬 알고리즘

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 10, 4, 2, 1, 9, 7, 6 };
        System.out.println("초기 배열: " + Arrays.toString(arr));
        insertSort(arr);
        String arrString = Arrays.toString(arr);
        System.out.println("정렬 후 배열: " + Arrays.toString(arr));
    }

    static void insertSort(int[] arr) {
        int n = arr.length; // 10
        int i = 1;
        while (i < n) { // 1부터 9까지 반복
            int curr = arr[i]; // 현재 인덱스의 값
            int j = i - 1; // 현재 인덱스의 이전 인덱스

            // 조건1) 현재 인덱스의 이전의 인덱스가 0보다 크고,
            // 조건2) 현재 인덱스 이전의 값이 현재 인덱스의 값보다 큰 경우 
            // 실행1) 현재 인덱스의 값에 현재 인덱스 이전의 값으로 재할당 한다.
            // -> 왜? 2)번 조건이 참이면, 현재 인덱스 이전의 값이 현재 인덱스보다 값이 크니까, 뒤로 이동시켜야 한다.
            // 실행2) 현재 인덱스의 이전이전 인덱스를 현재 인덱스의 이전 인덱스로 재할당 한다.
            // -> 왜? 현재 인덱스의 이전 인덱스를 현재 인덱스의 값으로 재할당 했으니까,
            // 현재 이전 인덱스의 이전 인덱스들도 모두 탐색해야 한다.
            // 그리고 j가 0보다 작아지면 반복문을 종료한다.
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // 현재 인덱스의 값을 현재 인덱스의 이전 인덱스 + 1 에 할당 한다.

            arr[j + 1] = curr;
            i = i + 1;
            System.out.println("i = " + i + ", j = " + j + ", " + Arrays.toString(arr));
        }
    }
}
