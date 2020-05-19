package leetcode.editor.cn;

/**
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * Related Topics 数组 双指针
 *
 * 解法1：暴力求解，循环遍历两次计算所有柱子组合能容纳的水，取出最大值
 * 时间复杂度 O(n^2), 空间复杂度 O(1)
 *
 * 解法2：双指针分别指向数组两端，每次移动的时候移小的那一端
 * 原因：面积 = min(x, y) * 距离. x和y分别是容器两端，假设 x < y, 则当y向内移动的时候，无论移动到哪面积都不可能比 x*原始距离(距离变近了，但是高度不可能变高)
 * 所以用 x 作为容器的一端已经不会增大容器盛水量，需要向内移动
 * 时间复杂度 O(n), 空间复杂度 O(1)
 */
public class P11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11_ContainerWithMostWater().new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1, max = 0;
            while (i < j) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static int maxArea01(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }
}
