//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2：
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1089 👎 0


public class SortColors{
      public static void main(String[] args) {
           Solution solution = new SortColors().new Solution();
           solution.sortColors(new int[]{1,2,0});
      }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
/*        循环不变量
        [0,p0) == 0;
        [p0,i) == 1; i也可以作为边界,一般都是半开半闭
        (p2,len-1] == 2
*/
        int p0 = 0;
        int i = 0;//i是自变量,用来推动程序进行,进行过程中要维护好循环不变量
        int p2 = len - 1;


        while(i <= p2){//因为p2是开区间,所以i = p2的时候也要进入循环
            if(nums[i]==0){
                swap(nums,p0,i);
                p0++;
                i++;
            } else if (nums[i] == 2) {//当=2时,交换回来的数字不能确定是0还是1,所以不能盲目移动边界i
                swap(nums,p2,i);
                p2--;
            }else{
                i++;
            }
        }
        return;
    }

    private void swap(int[] nums,int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}