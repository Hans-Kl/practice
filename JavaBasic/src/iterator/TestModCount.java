package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>2020/12/14 12:05</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestModCount {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        t1(integers);

    }

    private static void t1(List<Integer> list) {
        for (Integer integer : list) {
            list.remove(2);
            System.out.println(integer);
        }
    }

    private static void t2(List<Integer> list) {
        for (Integer integer : list) {
            list.iterator().remove();
            System.out.println(integer);
        }
    }
}
