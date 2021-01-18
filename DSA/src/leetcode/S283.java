package leetcode;

import java.util.Arrays;

/**
 * <p>2020/12/31 15:39</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class S283 {
    public static void moveZeroes(int[] nums) {
        int n = nums.length,i = 0,j = 0;
        while(n > j){
            if(nums[j] != 0){
                if(nums[i] == 0){
                    swap(nums,i,j);
                }
                i++;
            }
            j++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }



    public static void main(String[] args) {
        int[] a =new int[]{1,2,1,1,1};
        moveZeroes(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}

