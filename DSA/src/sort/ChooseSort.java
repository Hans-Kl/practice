package sort;

/**
 * 选择排序,代码是自己手写出来的,和算法4书里写的一模一样,加油!🆙
 * 时间复杂度在于交换N和比较(N^2)/2
 * 原地排序
 * <p>2020/12/15 11:20</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class ChooseSort extends BaseSort {
    public static void main(String[] args) {
        show(new ChooseSort().sort(new int[]{4, 6, 2, 7, 4, 1, 7, 4, 2, 5, 8}));
    }

    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {//交换局部最小与i,每次循环排定一个数字
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {//排定一个数字中,每次选出一个最小值
                if (less(arr[j], arr[minIndex])) minIndex = j;
            }
            exch(arr, i, minIndex);
        }
        return arr;
    }
}
