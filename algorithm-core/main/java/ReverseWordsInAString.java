import java.util.Arrays;

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
        String s = "  hello world!  ";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String[] arr = s.split(" ");
        if (arr.length==1) return s;
        StringBuffer sb = new StringBuffer();
        for(int i=arr.length-1; i>=0; i--) {
            if(!arr[i].equals("")) {
                sb.append(arr[i] + " ");
            }
        }
        return  sb.substring(0, sb.length()-1);
    }
}
