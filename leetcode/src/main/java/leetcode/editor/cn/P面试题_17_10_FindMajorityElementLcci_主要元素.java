package leetcode.editor.cn;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 *
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 说明：你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 * Related Topics 位运算 数组 分治算法
 */
public class P面试题_17_10_FindMajorityElementLcci_主要元素 {
    public static void main(String[] args) {
        System.out.println( 4 >> 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 摩尔投票
        // 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
        public int majorityElement(int[] nums) {
            // 投出可能为结果的数字
            int res = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (res == nums[i]) {
                   count ++;
                } else {
                    count --;
                    if (count == 0) {
                        res = nums[i];
                        count = 1;
                    }
                }
            }
            // 检查res是否超过一半
            int countR = 0;
            for (int e : nums) {
                if (e == res) {
                    countR ++;
                }
            }
            return countR >= (nums.length >> 1) + 1 ? res : -1 ;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}