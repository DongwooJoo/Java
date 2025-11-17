// 문자열의 동등성 비교 알고리즘을 만든다.
package org.array;

public class StringArray {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        System.out.println(equals(str1, str2));
        str1 = "hello";
        str2 = "hello";
        System.out.println(equals(str1, str2));
    }

    static boolean equals(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int len = str1.length();
        int i = 0;
        while (i < len && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i == len;
    }
}