import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例2：
 * 输入: "  hello world!  "
 * 输出: "world! hello" 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例3：
 * 输入: "a good   example"
 * 输出: "example good a"
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "  hello   world!  ";
        System.out.println(solution(s));
    }

    public static String solution2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String solution(String s) {
        int left = 0, right = s.length()-1;
        // 去掉字符串左右两边空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }

        // 去除字符串里面多余的空格
        StringBuffer sb = new StringBuffer();
        while(left <= right) {
            if (s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            } else if (sb.charAt(sb.length()-1) != ' ') {
                sb.append(' ');
            }
            left++;
        }

        // 反转整个字符串
        reverse(sb, 0, sb.length()-1);

        // 反转字符串中的每个单词
        int start=0,end=0;
        while(start < sb.length()) {
            while (end<sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end-1);
            start = end+1;
            end++;
        }
        return sb.toString();
    }

    public static void reverse(StringBuffer sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, tmp);
        }
    }

}
