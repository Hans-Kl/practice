//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 167 👎 0


import leetcode.TreeNode;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof{
      public static void main(String[] args) {
           Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
      }
      
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(! queue.isEmpty()){
            List<Integer> levelVal = new LinkedList<>();
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode head = queue.poll();
                levelVal.add(head.val);

                TreeNode left = head.left, right = head.right;
                if(left != null) queue.offer(left);
                if(right != null) queue.offer(right);
            }
            if(res.size() % 2 == 1) Collections.reverse(levelVal);
            res.add(levelVal);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

      
}