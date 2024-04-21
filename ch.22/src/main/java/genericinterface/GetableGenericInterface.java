package genericinterface;

interface Getable<T> {
    public T get();
}

class Box<T> implements Getable<T> {
    private T ob;

    public void set(T o) {
        this.ob = o;
    }

    @Override
    public T get() {
        return this.ob;
    }
}

class Toy {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}
public class GetableGenericInterface {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        box.set(new Toy());

        // Box<T> 가 Getable<T>를 구현하므로 참조 가능
        Getable<Toy> gt = box;
        System.out.println(gt.get());
    }
}

// class Box<T> implements Getable<T> { ... }
// -> Box<T> 클래스는 Getable<T> 인터페이스를 구현한다.
// 따라서, Getable<T> 형 참조변수로 Box<T> 인스턴스를 참조할 수 있다.
// 단, T 타입 파라미터에 오는 자료형이 Box를 생성한 타입 파라미터와 Getable이 참조하는 타입 파라미터와 동일해야 한다.