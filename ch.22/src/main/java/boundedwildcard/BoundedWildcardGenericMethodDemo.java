package boundedwildcard;

public class BoundedWildcardGenericMethodDemo {
    // box에 con과 동일한 내용물이 들었는지 확인한다.
    public static <T> boolean compBox(Box<? extends T> box, T con) {
        T bc = box.get(); // 24
//        box.set(con);     // con == 25 -> box.get() == 25
        return bc.equals(con); // 당연히 25가 나온다.
        // set을 못하게 해야 한다.
        // box.get() 과 con과 동일하다면,
    }

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(24);
        Box<String> box2 = new Box<>();
        box2.set("poly");

        if (compBox(box1, 25)) {
            System.out.println("상자 안에 25 저장");
        }
        if (compBox(box2, "moly")) {
            System.out.println("상자 안에 moly 저장");
        }

        System.out.println(box1.get());
        System.out.println(box2.get());
    }
}
