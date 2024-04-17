package beforegeneric;


class Apple {
    public String toString() {
        return "I am an apple";
    }
}
class Orange {
    public String toString() {
        return "I am an orange";
    }
}

class AppleBox {
    private Apple ap;

    public void set(Apple a) {
        this.ap = a;
    }

    public Apple get() {
        return this.ap;
    }

}

class OrangeBox {
    private Orange or;

    public void set(Orange o) {
        this.or = o;
    }

    public Orange get() {
        return this.or;
    }
}

public class FruitAndBox {
    public static void main(String[] args) {
        AppleBox appleBox = new AppleBox();
        OrangeBox orangeBox = new OrangeBox();

        appleBox.set(new Apple());
        orangeBox.set(new Orange());

        Apple ap = appleBox.get();
        Orange or = orangeBox.get();

        System.out.println(ap);
        System.out.println(or);
    }

}

// idea -> AppleBox, OrangeBox 를 하나의 클래스로 만들 수 있지 않을까?
