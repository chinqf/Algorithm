package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * Related Topics 排序 数组
 */
public class P56_MergeIntervals_合并区间 {
    public static void main(String[] args) {
        Solution solution = new P56_MergeIntervals_合并区间().new Solution();
        int[][] arr1 = {{5,6}, {2,3}, {4,7}, {8, 10}, {3, 5}};
        int[][] arr2 = {{1,3}, {2,6}, {8,10}, {15, 18}};
        int[][] arr3 = {{1,4}, {4,5}};
//        quickSort(arr2, 0 , arr2.length - 1);
//        for (int[] e: arr2) {
//            System.out.println(Arrays.toString(e));
//        }


        merge01(arr3);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：按照每个数组元素的第一个元素进行排序，然后进行第二个元素的替换
    // 执行耗时:4 ms,击败了93.45% 的Java用户
    public static int[][] merge01(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        quickSort(intervals, 0, intervals.length - 1);
        ArrayList<int[]> list = new ArrayList();
        int end = intervals[0][1];
        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i ++) {
            if (end >= intervals[i][0] && end <= intervals[i][1]) {
                end = intervals[i][1];
            } else if ( end < intervals[i][0] ) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        return list.toArray(res);
    }

    public static void quickSort(int[][] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = getIndex(arr, start, end);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    public static int getIndex(int[][] arr, int start, int end) {
        int[] point = arr[start];
        while (start < end) {
            while (start < end && arr[end][0] >= point[0]) {
                end --;
            }
            arr[start] = arr[end];
            while (start < end && arr[start][0] <= point[0]) {
                start ++;
            }
            arr[end] = arr[start];
        }
        arr[start] = point;
        return start;
    }

}