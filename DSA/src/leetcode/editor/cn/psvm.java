package leetcode.editor.cn;

import leetcode.TreeNode;

/**
 * TestTraverse
 *
 * @author klhans
 */
public class psvm {
    static int res = 0;
    static int rootDep = 0;

    public static void main(String[] args) {
        int i = maxDepth(TreeNode.of(3, 9, 20, null, null, 15, 7));
        System.out.println(i);
    }

    public static int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private static void traverse(TreeNode node) {
        if (node == null) return;
        rootDep++;
        System.out.println(node + "..." + rootDep);
        res = Math.max(res, rootDep);
        traverse(node.left);
        traverse(node.right);
        rootDep--;
        System.out.println(node + "..." + rootDep);

    }
}
