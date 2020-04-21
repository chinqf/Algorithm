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
        System.out.println(longestPalindrome("ababc"));
    }


    public static String longestPalindrome(String s) {
        String ans = null;
        int left_index = 0;
        int right_index = 0;
        int max = 0;
        Map<Integer, String> map = new HashMap();
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                for(int j=i+1; j<s.length(); j++) {
                    if (2*i - j - 1 < 0){
                        break;
                    }
                    if (s.charAt(j) == s.charAt(2*i-j-1)) {
                        left_index = 2*i-j-1;
                        right_index = j;
                    } else {
                        break;
                    }
                }
                ans = s.substring(left_index, right_index+1);
                map.put(ans.length(), ans);
                max = Math.max(max, ans.length());
            } else if (i>=2 && s.charAt(i) == s.charAt(i-2)) {
                for(int j=i; j<s.length(); j++) {
                    if (2*(i-1) - j < 0){
                        break;
                    }
                    if (s.charAt(j) == s.charAt(2*i-j-1)) {
                        left_index = 2*(i-1)-j;
                        right_index = j;
                    } else {
                        break;
                    }
                }
                ans = s.substring(left_index, right_index+1);
                map.put(ans.length(), ans);
                max = Math.max(max, ans.length());
            }
        }
        return map.get(max);
    }


}
