package sort;

/**
 * 冒泡排序
 * <p>2020/12/18 10:31</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class BubbleSort extends BaseSort {
    public static void main(String[] args) {
        show(new BubbleSort().sort(new int[]{4, 6, 2, 7, 4, 1, 7, 4, 2, 5, 8}));
    }

    @Override
    public int[] sort(int[] arr) {
        //每次泡泡操作都相当于从两个元素中选出最大的,移动泡,并作为下一次泡泡操作的参数
        // 这样就会不断的选出最大的泡泡,并把它推到顶部,所以称为冒泡排序
        for (int n = 0; n < arr.length; n++) {//n次冒泡
            for (int i = 0; i < arr.length - n - 1; i++) {//一次冒泡操作
                if (arr[i] > arr[i + 1]) exch(arr, i, i + 1);//泡泡操作
            }
        }
        return arr;
    }
}
