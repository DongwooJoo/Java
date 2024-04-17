package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeCollection {
    public static void main(String[] args) {
        Deque<Object> deq = new ArrayDeque<>();

        System.out.println("FIFO------------------");
        deq.addFirst("3.Robot");
        deq.addFirst("2.Toy");
        deq.addFirst("1.Box");
        System.out.println(deq.getFirst());
        System.out.println(deq.getFirst());
        System.out.println(deq.getFirst());
        System.out.println(deq.removeFirst());
        System.out.println(deq.removeFirst());
        System.out.println(deq.removeFirst());
        System.out.println("LIFO------------------------");
        deq.addLast("5.Box");
        deq.addLast("6.Toy");
        deq.addLast("7.Robot");
        System.out.println(deq.getLast());
        System.out.println(deq.getLast());
        System.out.println(deq.getLast());
        System.out.println(deq.removeLast());
        System.out.println(deq.removeLast());
        System.out.println(deq.removeLast());
        System.out.println("FIFO-------------------------");
        System.out.println(deq.offerFirst("1.Box"));
        System.out.println(deq.offerFirst("2.Toy"));
        System.out.println(deq.offerFirst("3.Robot"));
        System.out.println(deq.peekFirst());
        System.out.println(deq.peekFirst());
        System.out.println(deq.peekFirst());
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());
        System.out.println("LIFO------------------------");
        System.out.println(deq.offerLast("1.Box"));
        System.out.println(deq.offerLast("2.Toy"));
        System.out.println(deq.offerLast("3.Robot"));
        System.out.println(deq.peekLast());
        System.out.println(deq.peekLast());
        System.out.println(deq.peekLast());
        System.out.println(deq.pollLast());
        System.out.println(deq.pollLast());
        System.out.println(deq.pollLast());
    }
}

// 앞으로 넣기, 꺼내기, 확인하기
// addFirst      넣기
// removeFirst   꺼내기
// getFirst      확인하기
// -----------
// 뒤로 넣기, 꺼내기, 확인하기
// addLast       넣기
// removeLast    꺼내기
// getLast       확인하기
// -----------
// 앞으로 넣기, 꺼내기, 확인하기
// offerFirst    넣기
// pollFirst     꺼내기
// peekFirst     확인하기
// -----------
// 뒤로 넣기, 꺼내기, 확인하기
// offerLast
// pollLast
// peekLast
