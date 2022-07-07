package geek.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author klhans
 */
public class QuickSort {
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
        //注意需要包括>的情况
        if (left >= right) return;

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums,randomIndex,left);

        //不变量: [left + 1, lt] < p; [lt + 1, i) >=p
        int p = nums[left];
        int lt = left;
        for (int i = left + 1; i < right + 1; i++) {
            if (nums[i] < p) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, lt, left);
        return lt;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
