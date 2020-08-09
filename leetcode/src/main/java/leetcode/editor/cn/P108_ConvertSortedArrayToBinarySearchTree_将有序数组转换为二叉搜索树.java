package leetcode.editor.cn;

import common.node.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * Related Topics 树 深度优先搜索
 */
public class P108_ConvertSortedArrayToBinarySearchTree_将有序数组转换为二叉搜索树{
  public static void main(String[] args) {
       Solution solution = new P108_ConvertSortedArrayToBinarySearchTree_将有序数组转换为二叉搜索树().new Solution();
       int[] nums = {-10, -3, 0, 5, 9};
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      public TreeNode sortedArrayToBST(int[] nums) {
          return recur(nums, 0, nums.length - 1);
      }

      public TreeNode recur(int[] nums, int start, int end) {
          if (start > end) {
              return null;
          }
          int mid = (start + end ) / 2;
          TreeNode root = new TreeNode(nums[mid]);
          root.left = recur(nums, start, mid - 1);
          root.right = recur(nums, mid + 1, end);
          return root;
      }
  }
  //leetcode submit region end(Prohibit modification and deletion)

  // 每次选中间的节点作为根，层层往下：执行耗时:0 ms,击败了100.00% 的Java用户
  public static TreeNode sortedArrayToBST01(int[] nums) {
      return recur(nums, 0, nums.length - 1);
  }

  public static TreeNode recur(int[] nums, int start, int end) {
    if (start > end) {
        return null;
    }
    int mid = (start + end ) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = recur(nums, start, mid - 1);
    root.right = recur(nums, mid + 1, end);
    return root;
  }
}