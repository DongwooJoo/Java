package boundedwildcard;

class BoxContentsMover {
    // from에 저장된 내용물을 to로 이동
    public static void moveBox(Box<? super Toy> to, Box<? extends Toy> from) {
        to.set(from.get());
        // to -> get이 불가능하게 설계
        // from -> set이 불가능하게 설계
    }
}

public class MoveBoxContents {
    public static void main(String[] args) {
        Box<Toy> box1 = new Box<>();
        box1.set(new Toy());
        Box<Toy> box2 = new Box<>();
        BoxContentsMover.moveBox(box2, box1);
        System.out.println(box2.get());
    }
}


// 정리해보자.

// Box<? extends T> box
// -> T를 상속하는 클래스만 타입 파라미터로 올 수 있다. 타입 파라미터는 T를 상속하는 하위 클래스이다.
// -> 값을 반환하는 로직은 가능하다. 하지만, 저장하는 로직은 가능하다.
// -> 왜냐하면, 타입 파라미터에는 T를 상속하는 클래스 A가 올 것이다.
// 클래스 A가 moveBox를 사용할 경우,


// Box<? super T> box -> T가 상속하는 클래스만 타입 파라미터로 올 수 있다. 타입 파라미터는 T가 상속하는 상위 클래스이다.
