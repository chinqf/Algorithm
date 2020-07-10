package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * Related Topics 堆 分治算法
 */
public class P215_KthLargestElementInAnArray_数组中的第K个最大元素 {
    public static void main(String[] args) {
        Solution solution = new P215_KthLargestElementInAnArray_数组中的第K个最大元素().new Solution();
        int[] nums = {5, 8, 4, 2, 9, 7, 3};
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        moveEle(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    // 方法1：使用快排排序后取出对应元素
    public static int findKthLargest01(int[] nums, int k) {
        return 0;
    }

    public static void quickSort(int[] nums,) {

    }

    public static void moveEle(int[] nums, int start, int end) {
        int point = nums[start], left = start, right = end;
        while (left < right) {
            while (left < right ) {
                if (nums[right] < point) {
                    nums[left] = nums[right];
                    break;
                } else {
                    right--;
                }
            }
            while (left < right ) {
                if (nums[left] > point) {
                    nums[right] = nums[left];
                    break;
                } else {
                    left++;
                }
            }
        }
        nums[left] = point;
    }

    // 方法2：构建k个元素的大根堆
//    public int findKthLargest02(int[] nums, int k) {
//
//    }
//
//    // 方法3：对快速排序进行改进(原本需要对基准元素的两边都递归，可以采用二分法的思想对一边进行递归)
//
//    public int findKthLargest03(int[] nums, int k) {
//
//    }

}