//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 840 👎 0

  
public class MinimumSizeSubarraySum{
      public static void main(String[] args) {
           Solution solution = new MinimumSizeSubarraySum().new Solution();
      }
      
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //循环不变量:[slow, fast)是滑动窗口,返回值为fast - slow
        int slow = 0;
        int fast = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (fast < nums.length){
            //将fast纳入滑动窗口,这两行代码一起写,保证循环不变量.
            // 不要把fast++这行代码移到while循环后,那样滑动窗口的长度就维持不了循环不变量了
            sum += nums[fast];
            fast++;

            while(sum >= target){
                res = Math.min(res, fast - slow);

                sum -= nums[slow];
                slow++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

      
}