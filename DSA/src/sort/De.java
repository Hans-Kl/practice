package sort;

import java.util.Arrays;

/**
 * <p>2021/1/18 16:40</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class De {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] ints = Arrays.copyOf(a, a.length);
        a[1]=3;
        ints[0] = 5;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(ints));
    }
}
