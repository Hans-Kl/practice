package leetcode;

/**
 * 验证字符串是否是回文字符串
 * <p>2020/12/22 17:24</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class S124 {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return valid0(s.toString());
    }

    //用语言自带的String方法处理
    public boolean valid0(String s) {
        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }

    //首尾双指针遍历,注意不需要转为数组
    public boolean valid1(String s) {
        int first = s.charAt(0);
        int end = s.charAt(s.length() - 1);
        while (first < end) {
            if (s.charAt(first) != s.charAt(end)) return false;
            first++;
            end--;
        }
        return true;
    }
}
