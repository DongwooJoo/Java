package genericinheritance;

class EmptyBoxFactory {
    public static <T> Box<T> makeBox() { // 제네릭 메소드
        Box<T> box = new Box<>(); // 상자 생성
        return box; // 상자 리턴
    }
}
public class TargetTypes {
    public static void main(String[] args) {
        Box<Integer> iBox = EmptyBoxFactory.makeBox();
        iBox.set(25);
        System.out.println(iBox.get());
    }
}
// 자바 컴파일러는 생성된 자료형에 대해 유추하는 능력이 있다.
// 자료형 유추를 진행하는 상황이 매우 다양하다.

// 원래는 이렇게 작성해야 했다.
// Box<Integer> iBox = EmptyBoxFactory.<Integer>makeBox();
// 자바 7부터 우측의 타입 파라미터를 생략 가능해졌다.
// Box<Integer> iBox = EmptyBoxFactory.makeBox();

// 어떻게 가능할까?
// Box<Integer> box = new Box<>(); -> 컴파일러는 좌측의 타입 파라미터를 보고 우측의 타입을 추론한다. 따라서 다이아몬드 기호로 생략이 가능하다.
// 이와 마찬가지로 자바 7에서는 제네릭 메소드도 우측의 타입 파라미터가 생략 가능하다.
// 이 상황에서 우측의 T의 유추에 사용된 정보인 Box<Integer>를 '타겟 타입' 이라고 한다.
