package sort;

/**
 * 归并排序
 * <p>2021/1/13 17:41</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class MergeSort extends BaseSort {
    @Override
    public int[] sort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int[] mergeSort(int[] arr, int p, int q) {
        if (p == q) return arr;
        int r = (p + q) / 2;
        return merge(mergeSort(arr, p, r), mergeSort(arr, r + 1, q));
    }

    //将两个各自有序的数组合并成一个有序数组
    private int[] merge(int[] a1, int[] a2) {
        int[] ret = new int[a1.length + a2.length];
        int i1 = 0;
        int i2 = 0;
        int r = 0;
        while (i1 < a1.length && i2 < a2.length) {
            if (a1[i1] < a2[i2]) {
                ret[r] = a1[i1];
                i1++;
            } else {
                ret[r] = a2[i2];
                i2++;
            }
            r++;
        }
        return null;
    }
}
