package org.example.enumparamconstructor;

enum Person {
    MAN(29), WOMAN(25);

    private int age;
    private Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "I am " + age + " years old";
    }
}
public class EnumParamConstructor {

    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}
/*
열거형의 생성자는 무조건 private으로 선언해야 한다.
열거형 값의 선언에서 소괄호를 통해 생성자에 인자를 전달할 수 있다.

열거형도 Object 클래스를 상속하는 클래스다.
따라서 생성자, 인스턴스 변수, 메소드 모두 가질 수 있다.
다만 모든 생성자를 private로 선언해야 하기 때문에, "열거형 값"이 유일한 인스턴스 생성방법 이라는 차이가 있을 뿐이다.
 */