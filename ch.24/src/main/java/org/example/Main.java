package org.example;

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();
        Company company = new Company();
        Person person = new Person();

        System.out.println(developer);
    }
}


class Developer extends Company {
    private String name;

    public Developer() {
        super();
        System.out.println("a생성자");
    }

    public void abc() {
//        System.out.println("----------------");
//        System.out.println("super.bcd()");
//        super.bcd();
//        System.out.println("----------------");
//        System.out.println("super.toString");
//        System.out.println(super.toString());
//        System.out.println("----------------");
    }
}
class Company extends Person {
    private String companyName;

    public Company() {
        System.out.println("부모 생성자");
    }

    public void bcd() {
        System.out.println("company");
    }

    public void a() {
        System.out.println("a");
    }

//    public void abc() {
//        System.out.println("companyabc");
//    }
}

class Person {
    private String goal;

    public void abc() {
        System.out.println("person12312");
    }

}

