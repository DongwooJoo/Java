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

/*
가변인자의 메소드 정의 방식
public static void showAll(String...vargs) {...} // A 정의
public static void showAll(String[] vargs) {...} // B 정의
A는 B 메소드로 수정하여 컴파일을 완료한다.

showAll("Box", "Toy", "Apple"); // A 메소드 사용방식
showAll(new String[]{"Box", "Toy", "Apple"}); // B 메소드 사용방식

A는 B 메소드 사용방식으로 수정하여 컴파일을 완료한다.
*/