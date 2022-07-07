package leetcode;

/**
 * <p>2021/1/1 15:41</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class S27 {
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = 0, n = nums.length;

        while (j < n) {
            if (nums[j] != val) {
                // nums[j] = nums[i];
                if (i != j) nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

}
