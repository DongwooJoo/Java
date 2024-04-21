package boundedwildcard;

class BoxHandler4 {
    public static <T> void outBox(Box<? extends T> box) {
        T t = box.get();
        System.out.println(t);
    }

    public static <T> void inbox(Box<? super T> box, T t) {
        box.set(t);
    }

//    public static void outBox(Box<? extends Robots> box) {
//        box.set(n);
//    }
//    -> Type Erasure 때문에 에러 발생한다. -> 메소드 오버로딩으로 해결할 수 없으니 다른 방법을 찾아야 한다.
//    -> 이것도 제네릭으로 해결할 수 있지 않을까?
}

class Robots extends Toy{
    @Override
    public String toString() {
        return "I'm robots";
    }
}
// Box<Robots> 인스턴스 대상으로 outBox, inBox 메소드를 호출하고 싶다.
// 오버로딩해서 메소드 정의
public class BoundedWildcardGenericMethod {
    public static void main(String[] args) {
        Box<Toy> tBox = new Box<>();
        BoxHandler4.inbox(tBox, new Toy());
        BoxHandler4.outBox(tBox);

        Box<Robots> rBox = new Box<>();
        BoxHandler4.inbox(rBox, new Robots());
        BoxHandler4.outBox(rBox);
    }
}
// Box<Toy> 인스턴스와 Box<Robot> 인스턴스를 동시에 허용할 수 있도록 inBox, outBox 메소드를 정의하려면?
// -> 제네릭 메소드에 있다.