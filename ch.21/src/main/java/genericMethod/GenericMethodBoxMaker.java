package genericMethod;

class Box<T> {
    private T ob;

    public void set(T o) {
        this.ob = o;
    }

    public T get() {
        return ob;
    }
}


// 제네릭 메소드: 클래스 전부가 아닌 일부 메소드에 대해서만 제네릭으로 정의가 가능한데, 이렇게 정의된 메소드
// 인스턴스 메소드 뿐만 아니라, 클래스 메소드에 대해서도 정의가 가능하다.
// static 선언의 유무에 관계없이 제네릭 메소드 정의가 가능하다.

// 제네릭 클래스는 인스턴스 생성 시 자료형이 결정된다.
// 반면, 제네릭 메소드는 '메소드 호출 시'에 자료형이 결정된다.
class BoxFactory {
    public static <T extends Number> Box<T> makeBox(T o) { // 제네릭 메소드 정의
        Box<T> box = new Box<>(); // 상자 생성하고,
        box.set(o); // 인스턴스를 상자에 담아서
        System.out.println("Boxed data: " + o.intValue());
        return box; // 상자를 반환한다.
    }
}
// static 과 Box<T> 사이의 <T> 의 의미
// -> T가 타입 파라미터의 선언임을 컴파일러에게 명시한다.
// 왜? 제네릭이 정의되어 있지 않다면, 컴파일러는 메소드의 리턴 타입인 Box<T> 의 T가 무엇인지 모른다.

public class GenericMethodBoxMaker {
    public static void main(String[] args) {
//        Box<String> sBox = BoxFactory.makeBox("Sweet");
//        System.out.println(sBox.get());

        Box<Double> dBox = BoxFactory.makeBox(7.59); // 7.59에 대한 오토 박싱 진행됨.
        System.out.println(dBox.get());
    }
}

// Box<String> sBox = BoxFactory.<String>makeBox("Sweet");
// Box<Double> dBox = BoxFactory.<Double>makeBox(7.59);
// 우측의 타입 파라미터 String, Double 생략 가능
// Box<String> sBox = BoxFactory.makeBox("Sweet");
// Box<Double> dBox = BoxFactory.makeBox(7.59);
// 자료형의 유추는 오토 박싱까지 감안하여 이루어진다.

