package beforegeneric;


// 무엇이든 담을 수 있는 Box class 생성
class Box {
    private Object ob;

    public void set(Object o) {
        this.ob = o;
    }

    public Object get() {
        return this.ob;
    }
}

public class FruitAndBoxFault {
    Box appleBox = new Box();
    Box orangeBox = new Box();

    public static void main(String[] args) {
        Box aBox = new Box();
        Box oBox = new Box();

        aBox.set("Apple"); // 실수 부분. 원래라면 Apple, Orange 인스턴스를 set 해야 한다.
        oBox.set("Orange");

        Apple ap = (Apple)aBox.get(); // 형 변환 과정에서 예외 발생. -> 컴파일 시점에서 오류 감지.
        Orange or = (Orange)oBox.get();

        System.out.println(ap);
        System.out.println(or);
    }
}
// 컴파일 시점에 발생하는 오류는 좋다. 컴파일 오류는 원인을 바로 찾을 수 있기 때문이다.
// 런타임 시점에 예외가 발생한다면? 쉽게 발견되지 않는 경우도 있다.
// 컴파일 시점에 예외가 발생하도록 프로그램을 설계하는 것이 좋다.