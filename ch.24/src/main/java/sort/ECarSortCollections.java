package sort;

import java.util.ArrayList;

public class ECarSortCollections {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
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
        return "cc " + disp + ", ba: " + battery;
    }
}