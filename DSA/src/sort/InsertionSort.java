package sort;

/**
 * 插入排序,加油!
 * <p>2020/12/15 16:35</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class InsertionSort extends BaseSort {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i ; j > 0; j--) {
                if (arr[j] < arr[j-1]) exch(arr,j,j-1);//需要注意交换和比较都是和目标指针的前一个元素,而不是i,i在二层循环里是固定的.
            }
        }
        return arr;
    }

    //todo 优化:二分插入排序
    public int[] sortBinary(int[] arr) {
        return arr;
    }


    public static void main(String[] args) {
        show(new InsertionSort().sort(new int[]{4, 6, 2, 7, 4, 1, 7, 4, 2, 5, 8}));
    }
}
