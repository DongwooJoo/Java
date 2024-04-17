package boundedGeneric;

class Box<T extends Number> {
    private T ob;

    public void set(T o) {
        this.ob = o;
    }

    public T get() {
        return this.ob;
    }

    public int toIntValue() {
        return ob.intValue();
    }

    // 메서드 제한
    // class Box<T> {
    // ...
    // public int toIntValue() {
    //    return ob.intValue(); -> 에러 발생한다. 왜?
    //    }                        1. 인스턴스 ob 가 intValue() 메서드를 구현한다고 보장할 수 없기 때문이다.
    // }                           2. Java Object 클래스에는 intValue() 메서드가 없기 때문이다.
    //                             하지만, intValue() 를 구현하는 클래스를 타입 파라미터가 상속한다면?
    //                             인스턴스가 intValue() 를 갖는 것을 보장한다.
}

public class BoundedBox {
    public static void main(String[] args) {
        Box<Integer> iBox = new Box<>(); // Integer extends Number
        iBox.set(24);

        Box<Double> dBox = new Box<>();
        dBox.set(5.97);

        System.out.println(iBox.get());
        System.out.println(dBox.get());

        // 타입 파라미터 제한
        // Box<String> numberBox = new Box<>(); -> 에러 발생.
        // Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'
        // 타입 파라미터가 해당 범위에 있지 않는다. Number 를 상속해야 한다.
    }

}
// 담고 싶은 것을 제한한다. 클래스의 용도를 제한한다.
// -> extends 를 사용한다.

//
// public final class Integer extends Number {...}
// public final class Double extends Number {...}

