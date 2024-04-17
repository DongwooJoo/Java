package generic;

public class PrimitivesAndGeneric {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
//        Box<int> intBox = new Box<>();
        integerBox.set(125); // auto boxing
        Integer i = integerBox.get(); // auto unboxing
        System.out.println(i);
    }
}

// primitive type 은 type parameter 로 사용할 수 없다.
// Box<int> intBox = new Box<>(); 원시 타입 사용할 경우, 아래 에러 발생.
// Type argument cannot be of primitive type

// 타입 인자는 생략 가능하다.
// Box<Integer> integerBox = new Box<Integer>();
// Box<Integer> integerBox = new Box<>();
// -> 우측 제네릭 타입 생성자의 타입 파라미터 쓰는 자리를 다이아몬드 기호로 두면, 생략한다고 컴파일러에게 명시하는 것이다.
// 컴파일러는 왼쪽의 타입을 보고, 오른쪽 타입의 빈 공간을 채운다.
