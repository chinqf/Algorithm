package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

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
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest04(nums, 4));

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
            while (start < end && nums[end] >= point) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= point) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = point;
        return start;
    }

    // 方法2：构建k个元素的大根堆
    public static int findKthLargest02(int[] nums, int k) {
        int[] heap = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            heap[i] = nums[i];
            add(i, heap);
        }
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            delete(i, heap);
        }
        return heap[0];
    }

    public static void add(int index, int[] nums) {
        if (index <= 0) {
            return;
        }
        int tmp = nums[index];
        if (index % 2 == 0 && nums[index] > nums[(index - 2) / 2]) {
            nums[index] = nums[(index - 2) / 2];
            nums[(index - 2) / 2] = tmp;
            add((index - 2) / 2, nums);
        } else if (index % 2 == 1 && nums[index] > nums[(index - 1) / 2]) {
            nums[index] = nums[(index - 1) / 2];
            nums[(index - 1) / 2] = tmp;
            add((index - 1) / 2, nums);
        }
    }

    public static void delete(int index, int[] nums) {
        int i = 0;
        nums[0] = nums[index];
        while (2 * i + 1 < index) {
            int l = nums[2 * i + 1];
            int r = nums[2 * i + 2];
            int tmp = nums[i];
            if ((tmp >= l && tmp >= r)) {
                return;
            }
            if (l >= r && tmp < l) {
                nums[i] = l;
                nums[2 * i + 1] = tmp;
                i = 2 * i + 1;
            } else if (l < r && tmp < r) {
                nums[i] = r;
                nums[2 * i + 2] = tmp;
                i = 2 * i + 2;
            }
        }
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


    // 方法4：快排继续改进
    // 执行耗时:2 ms,击败了92.05% 的Java用户
    public static int findKthLargest04(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public static int quickSelect(int[] nums, int start, int end, int k) {
        int index = randomIndex(nums, start, end);
        if (index == nums.length - k) {
            return nums[index];
        }
        return index > nums.length - k ? quickSelect(nums, start, index-1, k) : quickSelect(nums, index + 1, end, k);
    }

    public static Random random = new Random();
    public static int randomIndex(int[] nums, int start, int end) {
        int rand = random.nextInt(end - start + 1) + start;
        int tmp = nums[rand];
        nums[rand] = nums[end];
        nums[end] = tmp;
        return getIndex(nums, start, end);
    }
}