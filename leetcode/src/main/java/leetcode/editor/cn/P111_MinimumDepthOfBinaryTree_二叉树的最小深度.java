package leetcode.editor.cn;

import common.node.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度 2.
 * Related Topics 树 深度优先搜索 广度优先搜索
 */
public class P111_MinimumDepthOfBinaryTree_二叉树的最小深度{
  public static void main(String[] args) {
    Solution solution = new P111_MinimumDepthOfBinaryTree_二叉树的最小深度().new Solution();
       
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    public int minDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      int left = minDepth(root.left);
      int right = minDepth(root.right);
      return root.left == null || root.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)
}