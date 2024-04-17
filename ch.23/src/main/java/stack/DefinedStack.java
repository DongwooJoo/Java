package stack;

import java.util.ArrayDeque;
import java.util.Deque;

interface DIStack<E> {
    public boolean push(E item);
    public E pop();
}

class DCStack<E> implements DIStack<E> {
    private Deque<E> deq;

    public DCStack(Deque<E> d) {
        deq = d;
    }

    public boolean push(E item) {
        return deq.offerFirst(item);
    }

    public E pop() {
        return deq.pollFirst();
    }
}

public class DefinedStack {
    public static void main(String[] args) {
        DIStack<String> stack = new DCStack<>(new ArrayDeque<String>());

        stack.push("1.Box");
        stack.push("2.Toy");
        stack.push("3.Robot");
        //
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

// Deque을 Stack 처럼 사용할 수 있으나,
// addFirst, addLast 앞, 뒤 모두 가능하기 때문에, 실수를 범할 수 있다.
// 따라서, Stack을 정의해서 사용하는 것이 명확하고, 실수를 줄일 수 있다.