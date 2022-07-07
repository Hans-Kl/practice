package leetcode.editor.cn;

import leetcode.TreeNode;

/**
 * @author klhans
 */
public class TestPrint {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode tree = TreeNode.of(3, 9, 20, 5, 4, 15, 7);
        tranverse(tree);
    }

    private static void tranverse(TreeNode root) {
        if (root == null) {
            return;
        }
        printIndent(count++);
        System.out.println(root.val);
        tranverse(root.left);
        tranverse(root.right);
        count--;

    }

    // 输入 n，打印 n 个 tab 缩进
    static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("+");
        }
    }
}
