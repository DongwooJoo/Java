package boundedGeneric;

import java.util.Collection;
import java.util.HashSet;

interface Eatable {
    public String eat();
}

interface Sellable {
    public Integer sell();
}

class Apple extends Number implements Eatable, Sellable {
    public String toString() {
        return "I am an apple";
    }

    @Override
    public String eat() {
        return "It tastes so good!";
    }

    @Override
    public Integer sell() {
        return null;
    }


    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}

// 타입 파라미터를 인터페이스, 클래스를 상속함으로써 제한할 수 있다.
// 하나의 클래스, 하나 이상의 인터페이스를 상속할 수 있다.
// 클래스는 1개만 상속되고, 맨 앞에 작성해야 한다.
// 아래의 경우, Number 를 상속하면서, 동시에 Eatable, Sellable 인터페이스를 구현하는 클래스만이 타입 파라미터로 올 수 있다.
class Box1<T extends Number & Eatable & Sellable> {
    T ob;

    public void set(T o) {
        this.ob = o;
    }

    public T get() {
        System.out.println(ob.eat()); // 타입 파라미터를 extends Eatable 로 제한했기 때문에, Eatable 의 메서드가 사용 가능하다.
        return this.ob;
    }
}

public class BoundedInterfaceBox {
    public static void main(String[] args) {
        Box1<Apple> box = new Box1<>();
        box.set(new Apple());

        Apple apple = box.get();
        System.out.println(apple);
    }

}