package generic;

public class DDBox<U, D> {
    private U u;
    private D d;

    public void set(U u1, D d1) {
        this.u = u1;
        this.d = d1;
    }

    public String toString() {
        return u.toString() + "\n" + d.toString();
    }

    public static void main(String[] args) {
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple", 25);

        DBox<String, Integer> box2 = new DBox<>();
        box2.set("Orange", 33);

        DDBox<DBox<String, Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
        ddbox.set(box1, box2);
        System.out.println(ddbox);
    }
}
