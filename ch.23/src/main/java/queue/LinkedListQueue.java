package queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {

    public static void main(String[] args) {
        Queue<String> que = new LinkedList<>();
        que.offer("Box");
        que.offer("Toy");
        que.offer("Robot");
        que.add("Dongwoo");
        que.remove("Robot");

        System.out.println("next: " + que.peek());
        System.out.println(que.poll());
        System.out.println("next: " + que.peek());
        System.out.println(que.poll());
        System.out.println("next: " + que.peek());
        System.out.println(que.poll());
    }
}
