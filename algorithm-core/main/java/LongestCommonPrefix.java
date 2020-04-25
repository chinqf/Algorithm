/** 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 示例：
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */


public class LongestCommonPrefix {
    public static void main(String[] args) {


    }

    public static String solution(String[] strs) {
        if (strs.length==0 || strs==null)
            return "";
        String res = strs[0];
        for (int i=0; i<strs.length; i++) {
            int j=0;
            for(j=0; j<strs[i].length() && j<res.length(); j++) {
                if (strs[i].charAt(j) != res.charAt(j))
                    break;
            }
            res = res.substring(0, j);
            if (res.equals(""))
                return "";
        }
        return res;
    }
}


