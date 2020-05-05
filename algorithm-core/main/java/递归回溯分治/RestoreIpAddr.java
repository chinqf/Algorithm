package 递归回溯分治;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */


public class RestoreIpAddr {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));


    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length()<4 || s.length()>12) {
            return ans;
        }
        back(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    /**
     *
     * @param s
     * @param pos   当前遍历到s字符串的位置
     * @param curr  当前存放已经确定好的ip段的数量
     * @param ans
     */
    private static void back(String s, int pos, List<String> curr, List<String> ans) {
        if (curr.size()==4) {
            // 刚好遍历到字符串末尾
            if(pos==s.length()) {
                ans.add(String.join(".",curr));
            }
            return;
        }

        // ip地址每段最多有三个数字
        for(int i=1; i<=3; i++) {
            // 如果当前位置距离s末尾小于3就不用再分段了, 直接跳出循环即可
            if (pos+i > s.length()) break;
            // 对s的子串分段
            String segment = s.substring(pos, pos+i);
            // 剪枝条件：段的起始位置不能为0, 段拆箱成int类型的长度不能大于255
            if(segment.startsWith("0") && segment.length()>1 || (i==3&&Integer.parseInt(segment) > 255)) {
                continue;
            }
            // 符合要求的段加入到curr中
            curr.add(segment);
            // 继续递归遍历下一个位置
            back(s, pos+i, curr, ans);
            // 回退到上一个元素，即回溯
            curr.remove(curr.size()-1);
        }

    }


}
