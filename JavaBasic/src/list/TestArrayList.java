package list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>2020/12/30 20:32</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestArrayList {
    public static void main(String[] args) {
//        t1();
//        t2();
//        t3();
        t4();
    }

    public static void t1() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        System.out.println(objects.size());
        objects.ensureCapacity(15);
    }

    public static void t2() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.set(0, 1);
        System.out.println(objects);
    }

    public static void t3() {
        System.out.println(10>>1);
    }

    public static void t4() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        System.out.println(integers.get(2));
        integers.remove(2);
        System.out.println(integers.get(2));



    }
}
