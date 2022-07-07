//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 526 👎 0


import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIi{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
      }
      
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add(0,levelVal);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

      
}