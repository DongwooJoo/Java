package genericinterface;

class Boxes<T> implements Getable<String> {
    private T ob;

    public void set(T o) {
        this.ob = o;
    }
    @Override
    public String get() {
        return ob.toString();
    }
}
public class GetableGenericInterface2 {
    public static void main(String[] args) {
        Boxes<Toy> box2 = new Boxes<>();
        box2.set(new Toy());

        Getable<String> gt = box2;
        System.out.println(gt.get());
        // Getable<String> 은 T의 자료형에 상관없이 참조할 수 있다.
    }
}
