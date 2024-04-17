package generic;

public class FruitAndBox2_Generic {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<Apple>();
        Box<Orange> orangeBox = new Box<Orange>();

        appleBox.set(new Apple());
        orangeBox.set(new Orange());

        Apple apple = appleBox.get();
        Orange orange = orangeBox.get();

        System.out.println(apple);
        System.out.println(orange);
    }
}
// Box<T> -> Box<Apple> == T를 Apple 로 결정하여 인스턴스 생성
// 따라서, Apple 또는 Apple 을 상속하는 하위 클래스의 인스턴스 저장 가능. 왜? 상속하게 되면, 하위 클래스는 상위 클래스의 모든 특성 + 하위 클래스의 특성이기 때문이다.

// 타입 매개변수(Type Parameter) == T  // ex. Box<T> 에서 T
// 타입 인자(Type Argument) == Apple // ex. Box<Apple> 에서 Apple
// 매개변수화 타입(Parameterized Type) == Box<Apple> == 제네릭 타입(Generic Type) // ex. Box<Apple> 에서 Box<Apple>

// 쉽게 이해해보자. 본질적인 단어만 생각하자.
// 매개변수 -> 일반화된 변수. 어떤 값이든 들어올 수 있음. -> T
// 인자 -> 파라미터로 들어오는 값. 파라미터로 정해진 값. -> Apple
// 타입 -> 타입. 클래스 타입. 매개변수화된 타입. -> Box<Apple> == 제네릭 타입

class BoxBeforeGeneric {
    private Object ob;

    public void set(Object o) {
        this.ob = o;
    }

    public Object get() {
        return this.ob;
    }
}

// ----------------------------
// 이전 Box -> 제네릭 Box
// Object -> T (자료형에 의존적이지 않은 형태)
// T는 인스턴스를 생성할 때 결정하면 된다.
// 클래스<T> 이런 식으로 제네릭 타입의 클래스임을 컴파일러에게 명시한다.

class Box<T> {
    private T ob;

    public void set(T o) {
        this.ob = o;
    }

    public T get() {
        return this.ob;
    }
}

class Apple {
    public String toString() {
        return "I am an apple";
    }
}
class Orange {
    public String toString() {
        return "I am an orange";
    }
}