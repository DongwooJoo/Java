package wildcard;

class Box<T> {
    private T ob;

    public void set(T o) {
        this.ob = o;
    }

    public T get() {
        return this.ob;
    }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class Unboxer {
    public static <T> T openBox(Box<T> box) {
        return box.get();
    }

    public static <T> void peekBox(Box<T> box) { // 제네릭 메소드
        System.out.println(box); // 상자 내용물 출력
    }
    // 제네릭 메소드를 정의한 이유가 Box<Integer>, Box<String>의 인스턴스를 인자로 받기 위함이라면,
    // 아래처럼 정의해도 되지 않을까?
    public static void peekBox2(Box<Object> box) {
        System.out.println(box);
    }

    // -> 안됨.
    // Box<Object> 와 Box<String>, Box<Integer> 은 상속관계를 형성할 수 없기 때문이다.
    // String, Object가 상속 관계에 있더라도,
    // Box<Object>, Box<String> 은 별개의 자료형이다.
    // 대신 와일드카드를 사용하면 원하는 바(상속)를 이룰 수 있다.
}

public class WildcardUnboxer {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("so simple string");
        Unboxer.peekBox(box); // 상자 안의 내용물 확인
//        Unboxer.peekBox2(box); // 컴파일 에러 발생 -> Required type: Box<Object> / Provided: Box<String>
    }
}
