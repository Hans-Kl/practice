package leetcode;

/**
 * <p>2021/1/3 20:09</p>
 *
 * @author 2onglinghan
 * @version 1.0
 */
public class S80 {
    public static void main(String[] args) {
        int[] param = new int[]{1,2,3};
        int i1 = removeDuplicates(param);
        for (int i = 0; i < i1; i++) {
            System.out.print(param[i]+",");
        }
    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 2) return nums.length;

        // 1.定义[0,index] 是修改后的满足要求的数组区间,这里已经把0 1 2 ...2- 1 ,共2个数 放进去了
        int i = 1;
        // 2.判断终止条件
        for(int j = 2;j < nums.length;j++){
            // 3.指针移动条件
            if(nums[i - 1] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        // 4.判断返回值
        return i + 1;
    }
}
