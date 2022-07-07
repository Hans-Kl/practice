package geek.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * 指针对撞解决重复元素
 *
 * @author klhans
 */
public class QuickSort2 {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] ints = {6, 5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(sortArray(ints)));
    }

    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        //注意需要包括>=的情况
        if (left >= right) return;

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
//      循环不变量:  [left+1,le) <= pivot; (ge,right]>=pivot
        int le = left + 1;
        int ge = right;
        while (true) {
//            //思考能这样写么??
//            if (le > ge) {
//                break;
//            }
            //必须是<,因为等于=的时候也要交换,不能直接吸收
            while (nums[le] < pivot
                    //注意这个条件
                    && le <= ge) {
                le++;
            }
            while (nums[ge] > pivot
                    && le <= ge) {
                ge--;
            }
            if (le > ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
