package geek.link;

/**
 * @author klhans
 */
public class Test1 {
    public static ListNode reverseList(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.of(new int[]{1,2,3,4});
        ListNode listNode = reverseList(node);
        ListNode.print(listNode);
    }
}
