package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * Related Topics 双指针 字符串
 */
public class P344_ReverseString_反转字符串 {
    public static void main(String[] args) {
        Solution solution = new P344_ReverseString_反转字符串().new Solution();
        char[] s = {'H','a','n','n','a','h'};
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 执行耗时:1 ms,击败了99.93% 的Java用户
        public void reverseString(char[] s) {
            for (int i = s.length % 2 == 0 ? s.length / 2 : s.length / 2 + 1; i < s.length; i++) {
                char tmp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = tmp;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}