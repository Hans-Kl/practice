package sort;

/**
 * 快排
 * <p>2021/1/13 18:12</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class QuickSort2 extends BaseSort {
    @Override
    public int[] sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    private int[] sort(int[] arr, int p, int q) {
        int i = part(arr, p, q);
        sort(arr, p, i - 1);
        sort(arr, i + 1, q);
        return arr;
    }

    // KLH: 对撞指针/双边扫描
    private int part(int[] arr, int p, int q) {
        return 0;
    }

    // KLH: 快慢指针/单边扫描
    private int part1(int[] arr, int p, int q) {
        return 0;
    }

    // KLH: 挖坑法
    private int part2(int[] arr, int p, int q) {
        return 0;
    }
}
