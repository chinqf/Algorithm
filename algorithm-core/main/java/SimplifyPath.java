import scala.math.Ordering;

import java.util.Arrays;
import java.util.Stack;

/** 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例1：
 * 输入："/home/"
 * 输出："/home"
 *
 * 示例2：
 * 输入："/../"
 * 输出："/"
 * 从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 示例3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 *
 * 示例4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 *
 * 示例5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 示例6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */

public class SimplifyPath {
    public static void main(String[] args) {
        String s = "/../";
        System.out.println(solution(s));

    }

    public static String solution(String path) {
        StringBuffer sb = new StringBuffer("/");
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length; i++) {
            if (arr[i].equals("..") && !st.isEmpty()) {
                st.pop();
            } else if (!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals("..")) {
                st.push(arr[i]);
            }
        }
        if (st.isEmpty()) {
            return sb.toString();
        }
        for (String str: st) {
            sb.append(str).append("/");
        }
        return sb.substring(0, sb.length()-1);
    }

}
