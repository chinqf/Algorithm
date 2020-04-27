import java.util.Arrays;

/** 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */


public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "ab";
        System.out.println(checkInclusion(s1, s2));

    }

    // 思路：s2的各个字母的数量跟s1的某个子串相同，说明s2包含s1的排列。可以采用滑窗遍历s2的子串
    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        // 创建两个数组来分别存储s1和s2的子串每个字符出现的次数(一共26个字母, 数组长度设置为26)
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }

        for(int j=s1.length(); j<s2.length(); j++) {
            if(isEqual(arr1, arr2))
                return true;
            arr2[s2.charAt(j-s1.length())-'a']--;
            arr2[s2.charAt(j)-'a']++;
        }
        if (isEqual(arr1, arr2)) {
            return true;
        }
        return false;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
