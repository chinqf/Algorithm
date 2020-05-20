package leetcode.editor.cn;

import java.util.Arrays;

/** 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例：
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * Related Topics 数组 双指针
 *
 * 解法1：双指针，i指向数组中第一个0元素，j往后移动，当j指向的元素非0时与i指向的元素交换，i往后移1
 */
public class P283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283_MoveZeroes().new Solution();
        int[] arr = {0, 1, 0, 3, 12};
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            for (; i < nums.length; i++) {
                if (nums[i] == 0) break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}