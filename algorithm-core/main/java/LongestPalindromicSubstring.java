import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome(""));
    }


    public static String longestPalindrome(String s) {
        if (s==null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;
        for(int i=0; i<strLen; i++) {
            left = i-1;
            right = i+1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len ++;
                left --;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len ++;
                right ++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left --;
                right ++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart+1, maxStart + maxLen + 1);
    }


}
