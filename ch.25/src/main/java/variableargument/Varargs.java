package variableargument;

public class Varargs {

    public static void main(String[] args) {
        System.out.println("LEN: " + args.length);
    }

    public static void mainForVarArgs(String...varargs) {
        System.out.println("LEN: " + varargs.length);
    }

    // 위의 두 코드는 같다.
    // (String...varargs) -> (String[] args) 가변 인자 선언(왼쪽)은 배열(오른쪽)로 변경되어 컴파일된다.
}
