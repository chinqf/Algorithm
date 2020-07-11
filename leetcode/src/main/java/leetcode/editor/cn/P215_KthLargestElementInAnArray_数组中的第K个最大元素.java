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
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest03(nums, 2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：使用快排排序后取出对应元素。执行耗时:38 ms,击败了9.25% 的Java用户
    public static int findKthLargest01(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = getIndex(nums, start, end);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    public static int getIndex(int[] nums, int start, int end) {
        int point = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= point ) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= point ) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = point;
        return start;
    }

    // 方法2：构建k个元素的大根堆
    public int findKthLargest02(int[] nums, int k) {

    }

    // 方法3：对快速排序进行改进(原本需要对基准元素的两边都递归，可以采用二分法的思想对一边进行递归)
    // 执行耗时:10 ms,击败了29.29% 的Java用户
    public static int findKthLargest03(int[] nums, int k) {
        sortHalf(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    public static void sortHalf(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int index = getIndex(nums, start, end);
        int targetIndex = nums.length - k;
        if (targetIndex < index) {
            sortHalf(nums, start, index - 1, k);
        } else if (targetIndex > index) {
            sortHalf(nums, index + 1, end, k);
        }
    }

}