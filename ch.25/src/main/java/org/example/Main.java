package org.example;

public class Main {

    public static void main(String[] args) {

        interface Language {
            int EN = 1; // 영어
            int KO = 2; // 한국어
            int HI = 3; // 힌디어
            int FR = 4; // 프랑스어
        }

        int en = Language.EN;

        switch(en) {
            case Language.EN:
                System.out.println("English");
                break;
            case Language.KO:
                System.out.println("Korean");
                break;
            case Language.HI:
                System.out.println("Hindi");
                break;
            case Language.FR:
                System.out.println("French");
                break;
            default:
                System.out.println("English");
        }
    }
}