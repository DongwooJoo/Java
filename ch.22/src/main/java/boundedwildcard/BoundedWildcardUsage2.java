package boundedwildcard;

class BoxHandler3 {
    public static void outBox(Box<? extends Toy> box) {
        Toy toy = box.get();
        System.out.println(toy);
    }

    public static void inBox(Box<? super Toy> box, Toy toy) {
        box.set(toy);
        // 1. Box의 타입 파라미터에는 Toy 클래스가 상속하는 클래스만 올 수 있다.
        // 2. box.get() 을 실행할 때는 문제가 발생하지 않는다.
        // 3. 하지만, box.get()에 반환하는 값을 저장하기 위한 선언한 참조변수 형을 Toy로 결정했다는 사실에서 문제가 발생한다.
        // Box<Toy> 가 전달된다면, Toy toy = box.get() -> get이 반환하는 것이 Toy 인스턴스이므로 문제가 없지만,
        // Box<Plastic> 이 전달되면, Toy toy = box.get() -> 참조 에러 발생.
        // 왜? Plastic이 부모 클래스이기 때문에, box.get()을 Toy로 할 수 없다.
        // -> Object o = box.get(); 만 가능하다. Object는 최상위 클래스 이기 때문이다.
        // 하지만, 자바는 Object 형 참조변수의 선언이나 Object 형의 형 변환이 불필요하도록 문법을 개선시켜왔다.
        // 왜냐하면, Object 라는 이름이 코드에 직접 등장하는 것은 컴파일러를 통한 오류의 발견 가능성을 낮추는 행위이기 때문이다.
        // 따라서, Object 로의 형 변환은 피하는 것이 좋다.
    }
}
public class BoundedWildcardUsage2 {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        BoxHandler3.inBox(box, new Toy());
        BoxHandler3.outBox(box);
    }
}
