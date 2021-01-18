//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1448 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.ListNode;

import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        String s ="dfa";
        ArrStack arrStack = new ArrStack(10);
        for (byte aByte : s.getBytes(StandardCharsets.UTF_8)) {
        arrStack.push(aByte);
        }
        
    }

    public boolean isValid(String s) {
        Map<Character,Character> pairs = new HashMap();
        pairs.put('(',')');
        pairs.put('{','}');
        pairs.put('[',']');
        Deque<Character> stack = new LinkedList();
        for(int i =0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(pairs.containsKey(c)) stack.push(b);
            else {
                char top = stack.pop();
                char p = pairs.get(top);
                if(p == c) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    private class ArrStack{
        private String[] items;
        private int count;

        public ArrStack(int size){
            this.items = new String[size];
            this.count = 0;
        }

        public boolean push(String item){
            if(count >= items.length) return false;
            items[count] = item;
            count++;
            return true;
        }

        public String pop(){
            if(count == 0 ) return null;
            String temp = items[count-1];
            count--;
            return temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
