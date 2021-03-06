package leetcode.editor.cn;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * Related Topics 位运算 哈希表
 */
public class P136_SingleNumber_只出现一次的数字 {
    public static void main(String[] args) {
        Solution solution = new P136_SingleNumber_只出现一次的数字().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 异或: 两个相同的数异或后的结果是0，所以所有的数字都进行异或计算后左后留下来的数就是最后结果
        // 执行耗时:1 ms,击败了99.67% 的Java用户
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res ^= nums[i];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}