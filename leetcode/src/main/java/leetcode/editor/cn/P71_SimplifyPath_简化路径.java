package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * <p>
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * 示例 5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * <p>
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * Related Topics 栈 字符串
 */

public class P71_SimplifyPath_简化路径 {
    public static void main(String[] args) {
        Solution solution = new P71_SimplifyPath_简化路径().new Solution();
        System.out.println(solution.simplifyPath("/home/"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：将path用'/'分解，然后把分解后的每个元素放到栈中，对特殊符号进行特殊处理
         * .或/ : 不放入栈，不做任何处理
         * .. : 不放入栈，从栈中弹出一个元素
         *
         * @param path
         * @return
         */
        public String simplifyPath(String path) {
            if (path == null || path.equals("/") || path.equals("")) {
                return path;
            }
            String[] words = path.split("/");
            LinkedList<String> list = new LinkedList<String>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("..") && !list.isEmpty()) {
                    list.removeLast();
                } else if (!words[i].equals(".") && !words[i].equals("") && !words[i].equals("..")) {
                    list.addLast(words[i]);
                }
            }
            StringBuffer sb = new StringBuffer();
            if (list.size() == 0) {
                return "/";
            }
            for (String str : list) {
                sb.append("/").append(str);
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 简化代码
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (String str: path.split("/")) {
            if (str.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!str.equals(".") && !str.equals("") && !str.equals("..")) {
                stack.push(str);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (String str: stack) {
            sb.append("/").append(str);
        }
        return stack.size() == 0 ? "/" : sb.toString();
    }
}