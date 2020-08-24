package leetcode.editor.cn;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6.。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * Related Topics 数组 分治算法 动态规划
 */
public class P53_MaximumSubarray_最大子序和 {
    public static void main(String[] args) {
        Solution solution = new P53_MaximumSubarray_最大子序和().new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int curr = nums[0];
            for (int i = 1; i < nums.length; i++) {
                curr = curr < 0 ? nums[i] : curr + nums[i];
                res = res > curr ? res : curr;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：logN
    // 执行耗时:1 ms,击败了95.93% 的Java用户
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = curr < 0 ? nums[i] : curr + nums[i];
            res = res > curr ? res : curr;
        }
        return res;
    }

}