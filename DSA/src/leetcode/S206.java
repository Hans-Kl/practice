package leetcode;

/**
 * 反转单链表
 * <p>2020/12/7 21:23</p>
 * 链表或者说简单数据结构的题目,考察的不是思维能力,而是实现能力,具体此题的话就是对指针的处理能力
 *
 * @author konglinghan
 * @version 1.0
 */
public class S206 {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode succ = head.next;
        ListNode curr = head;
        curr.next = null;
        while (curr.next != null) {
            ListNode next = succ;
            next.next = curr;
            curr = succ;
        }
        return curr;
    }

    //迭代
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode succ = curr.next;//缓存后继
            curr.next = prev;//反转当前指针
            prev = curr;
            curr = succ;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
