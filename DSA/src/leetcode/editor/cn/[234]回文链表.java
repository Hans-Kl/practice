//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 799 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution234 {
    //双指针确定链表中点,然后遍历判断
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q.next!=null){
            p=p.next;
            q=q.next.next;
        }
        ListNode min = p;
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
