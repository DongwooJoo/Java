package genericMethod;

// 제네릭 메소드도 메소드 호출 시, 전달되는 타입 인자를 제한할 수 있다.

public class BoundedGenericMethod {
    public static void main(String[] args) {
        Box<Integer> integerBox = BoxFactory.makeBox(9999);
        int n = UnBoxer.openBox(integerBox);
        System.out.println("Returned data: " + n);
    }

}
