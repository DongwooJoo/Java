package wildcard;

class Unboxer2 {
    public static <T> T openBox(Box<T> box) {
        return box.get();
    }

    public static <T> void peekBox2(Box<T> box) {
        System.out.println(box);
    }
    public static void peekBox(Box<?> box) { // 와일드카드 기호는 ? 로 표시한다.
        System.out.println(box);
    }

    // 제네릭 vs 와일드카드 -> 둘이 무슨 차이가 있을까? -> 기능적으로는 동일하다.
    // 즉, 제네릭 메소드와 와일드카드 기반 메소드는 상호 대체 가능하다.
    // 코드가 좀 더 간결하다는 이유로 와일드카드 기반 메소드 정의를 선호한다.

    // public static <T> void peekBox2(Box<T> box) { ... }
    // public static void peekBox(Box<?> box) { ... }
    // <T> 가 2번 들어가고, <?> 는 1번 들어간다.
    // 개인적인 취향과 별개로, 보편적인 선호도를 따라서 코드를 작성하는 것도 중요하다.
    // 왜냐하면 혼자 개발하는 것이 아니라, 주로 협업하기 때문이다. -> 실제 대화할 때 주로 사용하는 단어, 문맥을 쓰면 이해하기 수월한 것과 같다.
}
public class WildcardUnboxer2 {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("so simple generic");
        Unboxer2.peekBox(box); // 에러 발생하지 않음.
    }
}
