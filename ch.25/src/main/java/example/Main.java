package example;

public class Main {

    public static void main(String[] args) {

        enum Language {
            EN, KO, HI, FR,
        }

        Language lang = Language.EN;

        switch (lang) {
            case EN -> System.out.println("English");
            case KO -> System.out.println("Korean");
            case HI -> System.out.println("Hindi");
            case FR -> System.out.println("French");
        }

        enum Animal {
            DOG, CAT,
        }

        enum Person {
            MAN, WOMAN,
        }

        Person person = Person.MAN;
//        Animal person = Animal.CAT  -> 자료형 불일치로 인한 컴파일 오류 발생
        switch (person) {
            case MAN -> System.out.println("Man");
            case WOMAN -> System.out.println("Woman");
        }
    }

    class Shape {
        enum Type {
            Retangle, Circle, Triangle,
        }
        Type type = Type.Retangle;
        // class 내부에 enum 타입을 정의할 수 있다.
    }
}