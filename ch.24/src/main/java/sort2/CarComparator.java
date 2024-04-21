package sort2;


import java.util.*;

class Car {
    protected int disp;

    public Car(int d) {
        disp = d;
    }

    @Override
    public String toString() {
        return "cc: " + disp;
    }
}

class CarComp implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.disp - o2.disp;
    }
}

class ECar extends Car {
    private int battery;

    public ECar(int d, int b) {
        super(d);
        battery = b;
    }

    @Override
    public String toString() {
        return "cc: " + disp + ", ba: " + battery;
    }
}


public class CarComparator {

    public static void main(String[] args) {
        ArrayList<Car> clist = new ArrayList<>();
        clist.add(new Car(1800));
        clist.add(new Car(1200));
        clist.add(new Car(1600));

        ArrayList<ECar> elist = new ArrayList<>();
        elist.add(new ECar(3000, 55));
        elist.add(new ECar(1800, 84));
        elist.add(new ECar(1000, 99));

        CarComp comp = new CarComp();
        Collections.sort(clist, comp);
        Collections.sort(elist, comp);

        for (Iterator itr = clist.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next().toString());
        }
        System.out.println();

        for (Iterator itr = elist.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next().toString());
        }
        System.out.println();
    }
}