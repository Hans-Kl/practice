package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>2020/12/31 10:58</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestLinkedList {
    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        Deque deque = new LinkedList();
        deque.push(1);
        deque.push(2);
        deque.push(3);

//        System.out.println(deque.poll());
//        System.out.println(deque.poll());
//        System.out.println(deque.poll());
//        System.out.println(deque.poll());




        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }
}
