//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4060 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
          System.out.println(solution.threeSum(new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0}));
      }
      
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 3){
            return res;
        }
        //one <= two <= three
        Arrays.sort(nums);
        for(int one = 0; one < len; one++){
            if(one != 0 && nums[one] == nums[one - 1]){
                continue;
            }
            res.addAll(twoSum(nums, one));
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int oneIndex){
        int target = -nums[oneIndex];
        int startIndex = oneIndex + 1;
        List<List<Integer>> res = new ArrayList<>();
        //[startIndex,left)
        //[left, right)
        //[right,len - 1)
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                List<Integer> resItem = new ArrayList<>(3);
                resItem.add(nums[oneIndex]);
                resItem.add(nums[left]);
                resItem.add(nums[right]);
                res.add(resItem);

                if (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                if (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }

                left++;
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

      
}