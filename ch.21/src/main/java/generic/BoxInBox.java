package generic;

public class BoxInBox {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("I am the best developer in the world");

        Box<Box<String>> wBox = new Box<>();
        wBox.set(stringBox);
        // wBox.get() == stringBox == Box<String>
        // stringBox.get() == "I am the best developer in the world"

        Box<Box<Box<String>>> zBox = new Box<>();
        zBox.set(wBox);
        // zBox.get() == wBox
        // wBox.get() == stringBox
        // stringBox.get() == "I am the best developer in the world"

        System.out.println(zBox.get().get().get());
    }
}
// '매개변수화 타입'을 '타입 인자'로 전달하기
// 제네릭 타입(매개변수화 타입)은 타입 인자로 전달될 수 있다.
// 이 정도는 이해할 수 있어야 한다.