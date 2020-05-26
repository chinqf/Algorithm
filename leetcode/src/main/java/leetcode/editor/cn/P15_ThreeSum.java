package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
 * 的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * Related Topics 数组 双指针
 *
 * 解法：对数组进行排序，固定第一个数，设置两个指针，i指向第一个数之后的元素，j指向数组尾部。若三数之和>target, j左移，反之i右移，直到符合条件
 * 时间复杂度 O(n), 空间复杂度O(1)
 *
 */
public class P15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15_ThreeSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList();
            Arrays.sort(nums);
            for (int n = 0; n < nums.length - 2 ; n++) {
                // nums[n] > 0 则后面的数都比0大
                if (nums[n] > 0) {
                    break;
                }
                // 去重
                if (n >= 1 && nums[n] == nums[n-1]) {
                    continue;
                }
                int target = 0 - nums[n];
                int i = n + 1;
                int j = nums.length - 1;
                while (i < j) {
                    if (nums[i] + nums[j] == target) {
                        ArrayList<Integer> ele = new ArrayList<Integer>();
                        ele.add(nums[n]);
                        ele.add(nums[i]);
                        ele.add(nums[j]);
                        res.add(ele);
                        while (i < j && nums[i] == nums[i + 1]) i++;  // 去重
                        while (i < j && nums[j] == nums[j - 1]) j--;  // 去重
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}