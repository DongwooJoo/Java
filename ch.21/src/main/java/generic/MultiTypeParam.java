package generic;

class DBox<L, R> {
    private L left;
    private R right;

    public void set(L l, R r) {
        this.left = l;
        this.right = r;
    }

    @Override
    public String toString() {
        return left + " & " + right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

}
public class MultiTypeParam {
    public static void main(String[] args) {
        DBox<String, Integer> aBox = new DBox<>();
        DBox<String, Integer> oBox = new DBox<>();
        aBox.set("Apple", 25);
        oBox.set("Orange", 33);

        DBox<DBox<String, Integer>, DBox<String, Integer>> ddBox = new DBox<>();
        ddBox.set(aBox, oBox);
        DBox<String, Integer> left = ddBox.getLeft();
        DBox<String, Integer> right = ddBox.getRight();

        System.out.println(left);
        System.out.println(right);
    }
}

// Type Parameter 의 종류 -> 보편적으로 자주 사용하는 타입 파라미터와 그 의미이다.
// E == Element
// K == Key
// N == Number
// T == Type
// V == Value