package geek.link;

/**
 * @author klhans
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] vals) {
        ListNode dummyHead = new ListNode();
        ListNode pre = dummyHead;

        for (int i : vals) {
            ListNode cur = new ListNode(i);
            pre.next = cur;
            pre = cur;
        }
        return dummyHead.next;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode of = ListNode.of(new int[]{1, 3, 5, 6});
        print(of);
    }

    @Override
    public String toString() {
        return val + "";
    }
}
