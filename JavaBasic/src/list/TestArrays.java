package list;

import java.util.Arrays;
import java.util.List;

/**
 * <p>2020/12/29 15:24</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,};
        Integer[] integers = {1, 2, 3};
        List<int[]> ints1 = Arrays.asList(ints);
        List<Integer> integers1 = Arrays.asList(integers);
        System.out.println(ints1.size());
        System.out.println(integers1.size());
    }
}
