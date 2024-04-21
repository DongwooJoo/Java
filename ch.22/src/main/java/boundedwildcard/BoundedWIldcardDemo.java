package boundedwildcard;

public class BoundedWIldcardDemo {
    public static void addBox(Box<Integer> box1, Box<Integer> box2, Box<Integer> box3) {
        box3.set(box1.get() + box2.get());
        // box3 에서 꺼내는 것을 못하게 해야 한다.
        // box1, 2에 저장하는 것을 못하게 해야 한다.
    }

    public static void addBox2(Box<? super Integer> box1, Box<? extends Integer> box2, Box<? extends Integer> box3) {
//        System.out.println("box1 : " + box1.get());
//        System.out.println("box2 : " + box2.get());
//        System.out.println("box3 : " + box3.get());
        box1.set(box2.get() + box3.get());
//        System.out.println(box3.get());
    }

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(24); // box1 -> 24가 저장됨

        Box<Integer> box2 = new Box<>();
        box2.set(37); // box2 -> 37이 저장됨

        Box<Integer> result = new Box<>();
        result.set(0); // result -> 0이 저장됨

        addBox2(result, box1, box2);
        System.out.println(result.get());
    }
}
