package boundedwildcard;

class Box<T> {

    private T ob;
    public void set(T o) {
        this.ob = o;
    }
    public T get() {
        return this.ob;
    }

}

class Plastic {

}

class Toy extends Plastic {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxHandler {
    public static void outBox(Box<Toy> box) {
        Toy toy = box.get(); // 상자에서 꺼내기
        box.set(new Toy());
        System.out.println(toy);
    }
    // 프로그래머의 생각: 상자에서 내용물을 꺼내는 기능의 메소드를 정의하자.
    // 그런데 매개변수 box 대상으로 get은 물론 set도 호출이 가능하다.

//    public static void outBox(Box<Toy> box) {
//        Toy toy = box.get(); // get 기능 실행.
//        box.set(new Toy()); // set 기능도 실행? -> 작업의 실수이다. -> 이러한 실수는 컴파일 시점에 오류로 발견되지 않는다.
//        System.out.println(toy); //
//    }
//        -> 이러한 기능을 만들 때, get 은 가능하지만 set 은 불가능 하도록 메소드를 설계해야 프로그래머의 실수를 용납하지 않을 수 있다.
//        어떻게 할 수 있을까?

    public static void outBox2(Box<? extends Toy> box) {
        Toy toy = box.get();
        // box.set(); -> 저장하는 메소드의 호출이 불가능하다.
        System.out.println(toy);
    }

    public static void inBox(Box<Toy> box, Toy toy) {
        box.set(toy);
    }
}

class Robot extends Toy {

}
public class BoundedWildcardBase {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        Box<Robot> robotBox = new Box<>();
        BoxHandler.outBox2(box);
        BoxHandler.outBox2(robotBox);
        BoxHandler.inBox(box, new Toy());
        BoxHandler.outBox(box);
    }
}

// public static void peekBox(Box<? extends Number> box) {
//    // Box<T>의 T를 Number 또는 Number 를 직간접적으로 상속하는 클래스로 제한하기 위함.
// }

// public static void peekBox2(Box<? extends Integer> box) {
//    // Box<T>의 T를 Integer 또는 Integer 를 직간접적으로 상속하는 클래스로 제한하기 위함.
// }

// 다른 관점에서의 제네릭 메소드가 있음.

// 잘 만들어진 코드는 다음의 조건을 추가로 만족해야 한다.
// "필요한 만큼만 기능을 허용해서, 코드의 오류가 컴파일 과정에서 최대한 발견되도록 한다."


//public static void outBox2(Box<? extends Toy> box) {
    // Toy를 상속하는 하위 클래스인 T 타입 파라미터만 올 수 있다.
//    Toy toy = box.get();
//        box.set(toy); -> 에러 발생한다. 왜? 매개변수로 Toy 인스턴스를 저장할 수 있는 Box만 전달되는 사실을 보장할 수 없기 때문이다.
    // 매개변수로 Toy 인스턴스를 저장할 수 있는 Box만 전달되지 않는다.
    // 매개변수로 Box<Toy> 말고 다른 게 올 수 있다.
    // 무슨 말일까?

    // 아래 BoundedWildcardBase 클래스에서 outBox2를 사용한다고 하자.
    // Robot 클래스는 Toy 클래스를 상속한다. (== Robot 은 Toy 의 하위 클래스이다.)
    // outBox2 메서드에는 타입 파라미터가 Toy를 상속한다면, 어떤 Box도 들어갈 수 있다.
    // Robot을 담는 Box 일수도, Toy를 담는 Box 일 수도 있다는 의미이다.
    // 그런데, outBox2 메서드에서 set(T o)을 사용한다면?

    // outBox2(Box<Robot> box) {
    // Toy toy = box.get();
    // box.set(new Toy()); -> Box<Robot>에 Toy를 담을 수 없으므로, 에러를 발생시킨다.
    // (결론) 이런 문제점 때문에,
    // Box<? extends Toy> box 로 선언된 매개변수를 대상으로는, 저장하는 메소드의 호출이 불가능하다.

//        public class BoundedWildcardBase { ...
//        Box<Toy> box = new Box<>();
//        Box<Robot> robotBox = new Box<>();
//        BoxHandler.outBox2(box);
//        BoxHandler.outBox2(robotBox);
//        }
