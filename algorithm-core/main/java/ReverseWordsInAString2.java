import java.util.Arrays;

/** 翻转字符串里的单词2
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例：
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 注意：
 *
 * 单词的定义是不包含空格的一系列字符
 * 输入字符串中不会包含前置或尾随的空格
 * 单词与单词之间永远是以单个空格隔开的
 * 进阶：使用 O(1) 额外空间复杂度的原地解法。
 */
public class ReverseWordsInAString2 {
    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        solution(s);
        System.out.println(Arrays.toString(s));

    }

    // 翻转整个字符串，再翻转每个单词
    public static void solution(char[] s) {
        // 翻转整个字符串
        reverse(s, 0, s.length-1);

        // 翻转每个单词
        int start=0,end=0;
        while (start < s.length) {

            while (end<s.length && s[end]!=' ') {
                end++;
            }
            reverse(s, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    public static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
