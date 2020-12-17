package sort;

/**
 * 快排
 * 特点:
 * 1. 原地排序
 * 2. 时间复杂度低:NlgN
 * <p>2020/12/5 10:16</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class QuickSort extends BaseSort {

    public static void main(String[] args) {
        show(new QuickSort().sort(new int[]{4, 6, 2, 7, 4, 1, 7, 2, 5, 8}));
    }

    @Override
    public int[] sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);//我的错误return sort(arr, 0, arr.length);注意hi指向的是尾游标
    }

    private int[] sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return arr;
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);//我的错误:sort(arr, lo, p)
        sort(arr, p + 1, hi);
        return arr;
    }

    private int partition(int[] arr, int lo, int hi) {
        int value = arr[lo];
        int i = lo;
        int j = hi + 1;

        while (i < j) {//拒绝条件:i,j游标重合
//        while (true){
            while (arr[++i] < value) //拒绝条件:arr[i]>value
                if (i == hi) break;
            while (arr[--j] > value) {//拒绝条件:arr[j]<value
                if (j == lo) break;
            }
            if (i >= j) break;//我的错误:忽略了这个break条件,以为外层的while条件可以包住
            exch(arr, i, j);
        }
        // TODO: 2020/12/16 想象对arr[]{1,2,2}进行分区函数,走到这的时候i=1,j=0
        exch(arr, lo, i);//我的错误:写成了exch(arr, lo, i);
        return i;//我的错误:写成了return i;

    }

    public void testWhile(int i) {
        while (true) {
            if (i > 0) System.out.println(i);
            else break;
        }

        while (i > 0) {
            System.out.println(i);
        }
    }
}
