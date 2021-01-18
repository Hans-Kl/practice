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
        int r = (p+q)/2;
        return merge(mergeSort(arr, p, r), mergeSort(arr, r + 1, q));
    }

    private int[] merge(int[] a1, int[] a2) {
        return null;
    }
}
