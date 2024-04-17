package beforegeneric;

public class FruitAndBoxFault2 {
    public static void main(String[] args) {
        Box aBox = new Box();
        Box oBox = new Box();

        aBox.set("Apple"); // 실수 부분. 인스턴스를 set 해야 하는데, String을 넣었음.
        oBox.set("Orange");

        System.out.println(aBox.get()); // 실수 부분 2. 인스턴스를 get 할 때, Apple, Orange 클래스로 형 변환을 하지 않음.
        System.out.println(oBox.get());

        // Box의 타입이 Object인데, set할 때, String 인스턴스가 저장되었음.
        // 형변환을 하지 않아서 에러가 발생하지 않음.

        // 제네릭 등장 이전의 불편함: 상자에서 인스턴스를 꺼낼 때, 형 변환을 해야 한다.
        // 문제점: 형 변환을 하지 않으면, 컴파일 시점에 에러인지 알 수 없고, 런타임 시점에도 에러가 발생하지 않을 수 있다.
    }
}


