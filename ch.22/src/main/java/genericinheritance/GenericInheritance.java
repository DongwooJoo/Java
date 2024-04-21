package genericinheritance;

class Box<T> {
    protected T ob;
    public void set(T o) { this.ob = o; }
    public T get() { return this.ob; }
}

class SteelBox<T> extends Box<T> {
    public SteelBox(T o) { // 생성자
        ob = o;
    }
}

public class GenericInheritance {
    public static void main(String[] args) {
        Box<Integer> iBox = new SteelBox<>(7959); //
        Box<String> sBox = new SteelBox<>("simple");
        System.out.println(iBox.get());
        System.out.println(sBox.get());
    }
}

// SteelBox<T> extends Box<T> 관계가 성립한다면,
// SteelBox<String> extends Box<String> 관계도 성립히고,
// SteelBox<Integer> extends Box<Integer> 관계도 성립한다.

// 하지만, Box<Integer> extends Box<Number> 관계는 성립하지 않는다.
// 만약 Box<Number>를 Box<Integer> 가 상속 관계를 형성한다면, 혼란스러운 상속 구조가 될 것이다.
