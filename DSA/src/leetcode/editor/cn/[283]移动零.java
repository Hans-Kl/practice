//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 894 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        //错误思路:[两个思路, 1. 边遍历边移动,缺点:越靠后的元素移动次数越多
        // 2.全部遍历,用一个临时数组记录0的索引,最后一次性移动,所有非0元素都只会移动依次]
        // 第一个思路靠后的元素没有移动次数过多,虽然移动的步长变长了,但是因为是数组,所以移动的次数是固定的,也不需要额外的寻址
    }
}
//leetcode submit region end(Prohibit modification and deletion)
