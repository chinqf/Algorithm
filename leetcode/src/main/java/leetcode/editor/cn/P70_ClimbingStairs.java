package leetcode.editor.cn;

/**
 * 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 解法1：斐波拉契数列。n阶到达楼顶相当于n-1阶再爬一阶，n-2阶再爬2阶，所以相当于爬到n-1阶的方法 + 爬到n-2阶的方法
 * 时间复杂度 O(n), 空间复杂度 O(1)
 * 解法2：动态规划。状态转移公式 dp[n] = dp[n-1] + dp[n-2]
 * 时间复杂度 O(n), 空间复杂度 O(n)
 * 解法3：
 *
 */
public class P70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70_ClimbingStairs().new Solution();
        System.out.println(climbStairs02(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) return n;
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n-1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 解法2：动态规划
    public static int climbStairs02(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    // 解法1：斐波拉契
    public static int climbStairs01(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int res = first + second;
            first = second;
            second = res;
        }
        return second;
    }


}