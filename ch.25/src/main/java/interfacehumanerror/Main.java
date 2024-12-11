package interfacehumanerror;

public class Main {

    public static void main(String[] args) {
        who(Person.MAN);
        who(Animal.DOG);
    }

    public static void who(int man) {
        switch (man) {
            case Person.MAN ->
                System.out.println("남성 손님입니다.");
            case Person.WOMEN ->
                System.out.println("여성 손님입니다.");
        }

    }


    interface Animal {
        int DOG = 1;
        int CAT = 2;
    }

    interface Person {
        int MAN = 1;
        int WOMEN = 2;
    }

    // 인터페이스로 작성하면 Animal과 Person의 변수 이름은 다르지만, 값이 같으므로 의도치 않은 휴먼 에러가 발생할 수 있다.
    // 따라서, 열거형을 사용해서 이런 문제를 방지한다.

}