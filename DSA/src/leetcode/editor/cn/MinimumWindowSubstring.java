//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1458 👎 0


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
          String s = solution.minWindow("ADOBECODEBACNC", "ABC");
          System.out.println(s);
      }
      
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Character,Integer> sMap = new HashMap<>();
    Map<Character,Integer> tMap = new HashMap<>();
    public String minWindow(String s, String t) {
        for (char c : t.toCharArray()) {
            tMap.put(c,tMap.getOrDefault(c,0) + 1);
        }

        //[slow, fast)
        int slow = 0, fast = 0;
        //返回值 = [resR, resL)
        int resL = -1, resR = -1, resLen = Integer.MAX_VALUE;

        while(fast < s.length()){
            sMap.put(s.charAt(fast),sMap.getOrDefault(s.charAt(fast),0) + 1);
            fast++;

            while(check()){
                Integer curLen = fast - slow;
                if(curLen < resLen){
                    resL = slow;
                    resR = fast;
                    resLen = curLen;
                }

                sMap.put(s.charAt(slow),sMap.getOrDefault(s.charAt(slow),0) - 1);
                slow++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resL, resR);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Integer tCount = tMap.get(entry.getKey());
            if(sMap.getOrDefault(entry.getKey(),0) < tCount){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

      
}