package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ComputerSortCollections {
    public static void main(String[] args) {
        ArrayList<Computer> list = new ArrayList<>();
        list.add(new Laptop(16, 14));
        list.add(new Laptop(32, 15));
        list.add(new Laptop(64, 16));

        Collections.sort(list);

        for (Iterator<Computer> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next().toString() + '\t');
        }
    }
}


class Computer implements Comparable<Computer> {
    protected int ram;

    public Computer(int r) {
        ram = r;
    }

    @Override
    public String toString() {
        return "ram: " + ram;
    }

    @Override
    public int compareTo(Computer o) {
        return ram - o.ram;
    }
}

class Laptop extends Computer {
    private int size;

    public Laptop(int r, int s) {
        super(r);
        size = s;
    }

    @Override
    public String toString() {
        return "ram: " + ram + ", size: " + size;
    }
}