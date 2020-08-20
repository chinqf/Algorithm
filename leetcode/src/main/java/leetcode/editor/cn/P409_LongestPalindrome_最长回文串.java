package leetcode.editor.cn;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意: 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入: "abccccdd"
 * 输出: 7
 * 解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * Related Topics 哈希表
 */
public class P409_LongestPalindrome_最长回文串 {
    public static void main(String[] args) {
        Solution solution = new P409_LongestPalindrome_最长回文串().new Solution();
        String s = "abccccdd";
        System.out.println(solution.longestPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 把s转换为charArray时会比较快：2 ms, 在所有 Java 提交中击败了71.44%的用户
        public int longestPalindrome(String s) {
            int[] counts = new int[52];
            for (char c: s.toCharArray()) {
                if (c >= 65 && c <= 90) {
                    counts[c - 'A']++;
                }
                if (c >= 97 && c <= 122) {
                    counts[c - 'a' + 26]++;
                }
            }
            int sum = 0;
            for (int i = 0; i < counts.length; i++) {
                sum += (counts[i] / 2) * 2;
            }
            return sum < s.length() ? sum + 1 : sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：构造一个52长度的数组，代表26个大写英文字母和小写英文字母，对应位置上存储该位置对应的字符出现的次数
    // 双数计入长度，单数超过1的部分计入长度，最后如有单数则整体再加1
    // 执行耗时:6 ms,击败了35.40% 的Java用户
    public static int longestPalindrome(String s) {
        int[] counts = new int[52];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                counts[s.charAt(i) - 'A']++;
            }
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                counts[s.charAt(i) - 'a' + 26]++;
            }
        }
//        int sum = 0;
//        int flag = 0;
//        for (int i = 0; i < counts.length; i++) {
//            if (counts[i] % 2 == 0) {
//                sum += counts[i];
//            } else {
//                sum += counts[i] - 1;
//                flag = 1;
//            }
//        }
//        if (flag == 1) {
//            sum += 1;
//        }
//        return sum;
        // 改进上面这段代码
        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum += (counts[i] / 2) * 2;
        }
        return sum < s.length() ? sum + 1 : sum;
    }

}