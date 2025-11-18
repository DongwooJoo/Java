package main.java.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 10, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int target = 3;
        int result = binarySearch(arr, target);
        System.out.println(result);
    }

    private static int binarySearch(int[] arr, int target) {
        int indexL = 0;
        int indexH = arr.length - 1;
        while (indexL <= indexH) {
            int indexM = indexL + (indexH - indexL) / 2;
            System.out.println("indexM = " + indexM);
            if (arr[indexM] == target) {
                System.out.println("target found at index " + indexM);
                return indexM;
            } else if (arr[indexM] < target) {
                indexL = indexM + 1;
                System.out.println("indexL = " + indexL);
            } else {
                indexH = indexM - 1;
                System.out.println("indexH = " + indexH);
            }
        }
        return -1;
    }
}