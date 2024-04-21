package wildcard;

class Unboxer3 {
    public static void peekBox(Box<? extends Number> box) {
        System.out.println(box);
    }
}

public class UpperBoundedWildcard {
    public static void main(String[] args) {
        Box<Integer> iBox = new Box<>();
        iBox.set(1234);

        Box<Double> dBox = new Box<>();
        dBox.set(15.343);

        Unboxer3.peekBox(iBox);
        Unboxer3.peekBox(dBox);
    }
}

// 와일드카드의 상한과 하한
// 상한 -> 위에 제한 , 하한 -> 밑에 제한

// 1. 와일드 카드의 문법적 측면
//    public static <T> T openBox(Box<T> box) {
//        return box.get();
//    }
//
//    public static <T> void peekBox2(Box<T> box) {
//        System.out.println(box);
//    }
//    public static void peekBox(Box<?> box) {
//        System.out.println(box);
//    }

// 1-1. 상한 제한된 와일드 카드
// Box<? extends Number> box
// -> box 는 Box<T> 인스턴스를 참조하는 참조변수이다.
// -> 단, 이때 Box<T> 인스턴스의 T는 Number 또는 이를 상속하는 하위 클래스여야 한다.
//
