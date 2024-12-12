package variableargument;

import java.util.Arrays;

public class VarargsTest {

    public static void main(String[] args) {

        showAll("Box");
        showAll("Box", "Toy");

        showAll(new String[]{"Box2"});
        showAll(new String[]{"Box2", "Toy2"});

    }

    public static void showAll(String...varArgs) {
        for (String var : varArgs) {
            System.out.println(var);
        }
    }
}
