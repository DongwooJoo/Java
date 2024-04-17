package genericMethod;

class UnBoxer {
    public static <T> T openBoxing(Box<T> box) { // static, 메소드 명 사이의 <T> 는 리턴 타입 T가 타입 파라미터임을 컴파일러에게 명시하는 것이다.
        return box.get();
    }

    public static <T extends Number> T  openBox(Box<T> box) {
        System.out.println("Unboxed data: " + box.get().intValue());
        return box.get();
    }
}
public class GenericMethodBoxMaker2 {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("My generic method");

        String string = UnBoxer.openBoxing(box);
        System.out.println(string);
    }
}
