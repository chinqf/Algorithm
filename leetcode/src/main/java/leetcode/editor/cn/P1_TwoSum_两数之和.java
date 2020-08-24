package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * Related Topics 数组 哈希表
 */
public class P1_TwoSum_两数之和 {
    public static void main(String[] args) {
        Solution solution = new P1_TwoSum_两数之和().new Solution();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 执行耗时:2 ms,击败了99.60% 的Java用户
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                int pair = target - nums[i];
                if (map.containsKey(pair)) {
                    return new int[]{map.get(pair), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}