package wildcard;

class Unboxer4 {
    public static void peekBox(Box<? super Integer> box) {
        System.out.println(box);
    }
}
public class LowerBoundedWildcard {
    public static void main(String[] args) {
        Box<Integer> iBox = new Box<>();
        iBox.set(5555);

        Box<Number> nBox = new Box<>();
        nBox.set(Integer.valueOf(333));

        Box<Object> oBox = new Box<>();
        oBox.set("simple wildcard");

        Unboxer4.peekBox(iBox);
        Unboxer4.peekBox(nBox);
        Unboxer4.peekBox(oBox);
        // 추가 정보
        // new Integer(5555) 이렇게 생성자 함수를 쓰면 아래 에러가 발생한다.
        // 'Integer(int)' is deprecated since version 9 and marked for removal
        // 왜?
        // valueOf(int)를 쓰는게, 생성자로 쓸 때보다 성능 및 메모리 할당에서 성능상 유리하기 때문이다.

        // Integer.valueOf(5555)를 사용하면, 다음과 같은 문구가 뜬다.
        // Unnecessary boxing
        // -> 언박싱 할 필요 없다는 의미이다. 오토 박싱 해주니까
        // 즉, 5555 숫자 그대로 넣어도 된다.
    }
}
// Box<? super Integer> box
// -> box는 Box<T> 인스턴스를 참조하는 참조변수이다.
// -> 단, 이때 Box<T> 인스턴스의 T는 Integer 이 상속하는 클래스이어야 한다.

// public static void peekBox<? super Integer> box { ... }
// -> 위 메소드의 인자로 전달될 수 있는 인스턴스의 타입 종류는 다음과 같이 하한 제한된다.
// Box<Integer> , Box<Number> , Box<Object>

// T 타입 파라미터가 Integer 로부터 상속받는다는 의미이기 때문에,
// T 타입 파라미터는 Integer 가 상속하는 클래스로 제한된다.
// 즉, T 타입 파라미터는 Integer 하위 클래스가 될 수 없다는 의미이다.

// super 키워드
// 부모 클래스로부터 상속받은 멤버 변수를 참조하는데 사용되는 참조 변수이다.
// 멤버 변수와 지역변수의 이름이 같을 때 this 를 붙여서 구별한다.
// 이처럼, 상속받은 멤버 변수와 자신의 멤버 변수가 이름이 같을 때는 super 를 붙여서 구별할 수 있다.