package sort;

/**
 * 排序算法基类
 * <p>2020/12/5 10:26</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class BaseSort {
    public static void exch(Comparable[] a, int i, int j) {
        Comparable v = a[i];
        a[i] = a[j];
        a[j] = v;
    }

    public static void exch(int[] a, int i, int j) {
        int v = a[i];
        a[i] = a[j];
        a[j] = v;
    }

    public static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(a + " ");
        }
    }

    public static void show(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public int[] sort(int[] arr) {
        return arr;
    }

}
