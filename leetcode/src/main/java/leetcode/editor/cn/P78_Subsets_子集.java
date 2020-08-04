package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 * Related Topics 位运算 数组 回溯算法
 */
public class P78_Subsets_子集 {
    public static void main(String[] args) {
        Solution solution = new P78_Subsets_子集().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            recur(nums, 0, new ArrayList<Integer>());
            return result;
        }

        public void recur(int[] nums, int level, ArrayList<Integer> item) {
            if (level == nums.length) {
                result.add(new ArrayList<Integer>(item));
                return;
            }
            recur(nums, level + 1, item);
            item.add(nums[level]);
            recur(nums, level + 1, item);

            item.remove(item.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：用二进制和位运算，nums有多长就有多少位，每一位要么是0要么是1
    // 执行耗时:1 ms,击败了99.15% 的Java用户。 内存消耗:40 MB,击败了63.55% 的Java用户
    public static List<List<Integer>> subsets01(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         // 外层循环: 因每一位要么是0要么是1，所以有2^n种子集
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                // 从右往左判断各个位是0还是1
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            result.add(sub);
        }
        return result;
    }

    // 方法2：回溯，递归树的中序遍历
    // 执行耗时:1 ms,击败了99.15% 的Java用户
    static List<List<Integer>> result = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets02(int[] nums) {
        recur(nums, 0, new ArrayList<Integer>());
        return result;
    }

    public static void recur(int[] nums, int level, ArrayList<Integer> item) {
        if (level == nums.length) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        // 不选
        recur(nums, level + 1, item);
        // 选
        item.add(nums[level]);
        // 回溯
        recur(nums, level + 1, item);

        // 回溯的时候需要注意清理一下，回归之前状态
        item.remove(item.size() - 1);
    }

}