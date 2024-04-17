package set;

import java.util.HashSet;

public class HowHashCode {
    public static void main(String[] args) {
        HashSet<Car> set = new HashSet<>();
        set.add(new Car("301", "red"));
        set.add(new Car("302", "black"));
        set.add(new Car("302", "red"));
        set.add(new Car("302", "white"));
        set.add(new Car("302", "black"));
        System.out.println("인스턴스 수 : " + set.size());

        for (Car car : set) {
            System.out.println(car.toString() + '\t');
        }
    }
}

class Car {
    private String model;
    private String color;

    public Car(String m, String c) {
        model = m;
        color = c;
    }

    @Override
    public String toString() {
        return model + " : " + color;
    }

//    @Override
//    public int hashCode() {
//        return (model.hashCode() + color.hashCode() / 2);
//    }

    @Override
    public boolean equals(Object obj) {
        String m = ((Car)obj).model;
        String c = ((Car)obj).model;

        if (model.equals(m) && color.equals(c)) {
            return true;
        } else {
            return false;
        }

    }
}
