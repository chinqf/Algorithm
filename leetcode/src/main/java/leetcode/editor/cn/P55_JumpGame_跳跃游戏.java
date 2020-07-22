package leetcode.editor.cn;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * Related Topics 贪心算法 数组
 */
public class P55_JumpGame_跳跃游戏 {
    public static void main(String[] args) {
        Solution solution = new P55_JumpGame_跳跃游戏().new Solution();
        System.out.println(canJump01(new int[]{3,2,1,0,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int reach = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums.length - 1 <= reach) {
                    return true;
                }
                if (i <= reach) {
                    reach = Math.max(i + nums[i], reach);
                } else {
                    return false;
                }
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：贪心，遍历数组，维护最远可到达的位置，最远可到达的位置包括末尾则可直接返回true，遍历完都不行则返回false
    // 执行耗时:2 ms,击败了77.25% 的Java用户
    public static boolean canJump01(int[] nums) {
        int reach = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - 1 <= reach) {
                return true;
            }
            if (i <= reach) {
                reach = Math.max(i + nums[i], reach);
            } else {
                return false;
            }
        }
        return false;
    }
}