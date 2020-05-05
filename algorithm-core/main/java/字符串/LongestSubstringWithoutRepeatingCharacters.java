package 字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例1：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例2：
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例3：
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 思路：滑动窗口，[i, j)，碰到没在前面出现的元素，j往后递增，碰到一样的i跳至[i,j)范围内相同元素后面那个位置，使用HashMap存储位置
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {



    }

    public static int solution01(String s) {
        int res = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while(start < s.length() && end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(end-start, res);
            }
        }
        return res;
    }

    // 使用 HashMap存储索引位置
    public static int solution02(String s) {
        int res = 0;
        int i = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int j=0; j<s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            res = Math.max(res, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return res;
    }
}
