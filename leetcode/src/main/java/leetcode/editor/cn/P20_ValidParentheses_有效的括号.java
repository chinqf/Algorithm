package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * Related Topics 栈 字符串
 */
public class P20_ValidParentheses_有效的括号 {
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses_有效的括号().new Solution();
        System.out.println(isValid03("(([]){})"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
                return isValid(s.replace("()", "").replace("[]", "").replace("{}", ""));
            } else {
                return "".equals(s);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：用栈  执行耗时:2 ms,击败了80.19% 的Java用户
    public static boolean isValid01 (String s) {
        LinkedList<Character> chars = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chars.isEmpty()) {
                char last = chars.getLast();
                if ((last == '(' && c == ')') || (last == '[' && c == ']') || (last == '{' && c == '}')) {
                    chars.removeLast();
                } else if ((last == '(' && (c == ']' || c == '}')) || (last == '[' && (c == ')' || c == '}')) || (last == '{' && (c == ']' || c == ')'))) {
                    return false;
                } else {
                    chars.addLast(c);
                }
            } else {
                chars.addLast(c);
            }
        }
        return chars.isEmpty() ? true : false;
    }

    // 方法2：同样用栈，但代码简化很多  执行耗时:1 ms,击败了98.60% 的Java用户
    public static boolean isValid02 (String s) {
        LinkedList<Character> chars = new LinkedList();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                chars.addLast(')');
            } else if (c == '{') {
                chars.addLast('}');
            } else if (c == '[') {
                chars.addLast(']');
            } else if (chars.isEmpty() || chars.removeLast() != c) {
                return false;
            }
        }
        return chars.isEmpty();
    }

    // 方法3：递归加字符串替换(代码最简单，但是最慢)  执行耗时:45 ms,击败了5.38% 的Java用户
    public static boolean isValid03 (String s) {
        if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            return isValid03(s.replace("()", "").replace("[]", "").replace("{}", ""));
        } else {
            return "".equals(s);
        }
    }

}