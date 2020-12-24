//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 150 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.ListNode;
import leetcode.Wrong;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
// KLH: 考验链表代码的实操能力:链表代码的特点是思路简单,但写代码时node容易混乱
class Solution {

    // KLH: 错误原因:以为遍历链表必须要一个额外局部变量,其实不需要
    //  但是反转链表是需要两个局部变量的,一个用来存储下一个节点,防止断链,一个用来存储上一个节点,用来改变指针指向
    @Wrong
    public ListNode wrong(ListNode head) {
        ListNode cur = head;
        ListNode nnext = cur.next.next;//保存一个next节点快照
        while (nnext != null) {
            cur.next.next = cur;
            cur = cur.next;
        }
        return cur;
    }

    // KLH: 迭代法
    public ListNode reverseList0(ListNode head) {
        ListNode pre = null;//存储上一个节点,改变指向使用
        ListNode next = null;//存储下一个节点,防止断链
        while (head != null) {
            next = head.next;//先存上下一个节点
            head.next = pre;//反转指向
            pre = head;//存上下一个节点,留着下次循环反转时使用
            head = next;//进行下次循环
        }
        return pre;//当节点为空的时候,说明链表到头了,返回上一个不为空的节点
    }


    // KLH: 递归法
    public ListNode reverseList1(ListNode head) {
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
