import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        if(len < 3) return res;

        Arrays.sort(nums);

        for(int i = 0; i < len; i++){
            if (nums[i] > 0) return res;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;

            while (left < right){
                int sum = nums[left] + nums[right];
                if (sum < target){
                    left++;
                }else if (sum > target){
                    right--;
                }else {
                    List<Integer> resItem = new ArrayList<>(3);
                    resItem.set(0, nums[i]);
//                    resItem.set(1, nums[left]);
//                    resItem.set(2, nums[right]);
                     resItem.add(nums[i]);
                     resItem.add(nums[left]);
                     resItem.add(nums[right]);
                    res.add(resItem);
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}