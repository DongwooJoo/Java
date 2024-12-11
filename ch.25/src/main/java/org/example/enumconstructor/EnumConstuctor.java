package org.example.enumconstructor;

enum Person {
    MAN, WOMAN;

    private Person() {
        System.out.println("Person contructor called");
    }

    @Override
    public String toString() {
        return "I am dog person.";
    }
}


public class EnumConstuctor {

    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}


// 두 개의 열거형 값에 대해, 생성자 호출이 발생

// 실행 결과
/*
> Task :org.example.enumconstructor.EnumConstuctor.main()
Person contructor called
Person contructor called
I am dog person.
I am dog person.
*/

/*

Java의 열거형(enum)은 특별한 형태의 클래스이며, 각 열거형 값은 해당 열거형 클래스의 상수 인스턴스이다.
Person.MAN과 Person.WOMAN은 Person 열거형의 두 개의 상수 인스턴스이다.

열거형 값의 실체: 열거형의 각 값은 다음과 같이 컴파일러에 의해 "싱글톤 객체"로 변환된다.

public static final Person MAN = new Person("MAN");
public static final Person WOMAN = new Person("WOMAN");

왜 열거형 값이 상수 객체로 변환되는가?
1. 컴파일러 동작: 컴파일 시, 각 열거형 값은 열거형 클래스의 static final 객체로 변환됩니다.
2. 클래스 로딩 시점에 초기화: 열거형 값은 클래스가 로드될 때 정적으로 초기화되므로, 열거형 값이 고유하며 불변(immutable)합니다.
3. 생성자 호출: 열거형의 생성자는 각 열거형 값에 대해 한 번씩 호출되며, 생성자를 통해 고유 상태를 설정할 수 있습니다.

코드 실행 과정
1.Person.MAN과 Person.WOMAN은 Person 열거형 클래스의 두 인스턴스로 초기화됩니다.
2.각 열거형 값의 생성자가 호출되면서 System.out.println("Person constructor called")이 출력됩니다.
3.System.out.println(Person.MAN) 호출 시, 열거형의 toString() 메서드가 호출되어 "I am dog person."이 반환됩니다.

열거형 값의 특징
열거형 값은 정적(final)이므로 변경할 수 없습니다.
각 열거형 값은 고유한 인스턴스로, 열거형 내에서 싱글톤 패턴을 따릅니다.
열거형 값의 초기화는 정적 초기화 블록과 유사하게 동작합니다.

결론적으로, 열거형 값의 실체는 해당 열거형 클래스의 static final 객체이다.
이를 통해 열거형 값은 고유성을 가지며, 생성자 호출은 상수 객체가 생성될 때 한 번만 이루어진다.
이러한 특성 덕분에 열거형은 타입 안정성과 코드 가독성을 제공하며, 특정 상수 값을 나타내는 데 유용하게 사용된다.
 */