package boundedwildcard;

class BoxHandler2 {
    public static void outBox(Box<? extends Toy> box) {
        Toy toy = box.get();
        System.out.println(toy);
    }

    public static void inBox(Box<Toy> box, Toy toy) {
        box.set(toy);
        box.get(); // -> 저장하는 메소드에서 값을 반환하는 메소드가 사용 가능하면 안 된다. -> 하한 제한이 필요하다.
    }
}
public class BoundedWildcardUsage {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        BoxHandler2.inBox(box, new Toy());
        BoxHandler2.outBox(box);
    }
}
