package geek.mergesort;

import java.util.Arrays;

/**
 * @author klhans
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = {6, 5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(sortArray(ints)));
    }

    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len];
        mergeSort(nums, 0, len - 1, tmp);
        return nums;
    }

    private static void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (left == right) return;
        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);

        if (nums[mid] <= nums[mid + 1]) return;//优化:如果两个子数组合起来本身就有序,则不需要合并了

        merge(nums, left, mid, right, tmp);//合并过程,在每次递归之后调用
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        System.arraycopy(nums,left,tmp,left,right - left + 1);//拷贝数组

        //这里注意tmp数组下标与nums数组下标的转换
        int p = left;//p指向左子数组的头部
        int q = mid + 1;//q指向右子数组的头部

        for (int i = left; i <= right; i++) {
            int min;
            if (p == mid + 1) {//左数组已经全部遍历完,直接将右数组复制到结果中
                min = tmp[q];
                q++;
            } else if (q == right + 1) {
                min = tmp[p];
                p++;
            } else if (tmp[p] <= tmp[q]) {
                min = tmp[p];
                p++;
            } else {
                min = tmp[q];
                q++;
            }

            nums[i] = min;
        }
    }

}
