package 字符串;

import java.util.HashMap;
import java.util.Map;

/** 最长回文子串
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

    // 中心扩散方法
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int left = 0, right = 0, maxLen = 0, minLeft = 0, len = 1, strLen = s.length();
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(i) == s.charAt(right)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                minLeft = left;
            }
            len = 1;
        }
        return s.substring(minLeft+1, minLeft + maxLen + 1);
    }

    /** 动态规划
     * 用 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文
     * 初始状态：l=r时，此时dp[l][r]=true
     * 状态转移方程：dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true
     * @param s
     * @return
     */
    public static String longestPalindrome02(String s) {
        if (s == null || s.length() == 0) return "";
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);

    }

}
