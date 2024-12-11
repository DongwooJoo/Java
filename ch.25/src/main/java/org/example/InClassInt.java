package org.example;

class InClassInt {
    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}

class Person {

    private String name;
    private int age;

    public static final Person MAN = new Person("a", 1);
    public static final Person WOMAN = new Person("b", 2);

    @Override
    public String toString() {
        return "I'm " + name + " who learn programming. My Age is " + age + " years old.";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
/*
main 함수를 실행했을 때, 위 소스코드의 결과가
I am a person who learn programming.
I am a person who learn programming.
왜 MAN, WOMAN 변수는 Person 객체가 아니라 String으로 출력되는 걸까?

Java에서 객체를 System.out.println()으로 출력하면, 객체의 toString() 메서드가 호출된다.
Object 클래스에서 기본적으로 제공되는 toString() 메서드는 객체의 클래스 이름과 해시코드를 반환한다.
예를 들면 Person@1a2b3c.
하지만 Person 클래스에서 toString() 메서드를 오버라이딩하여 "I am a person who learn programming."를 반환된다.

*/

