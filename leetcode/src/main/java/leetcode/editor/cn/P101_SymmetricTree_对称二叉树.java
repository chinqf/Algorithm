package leetcode.editor.cn;

import common.node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *      1
 *    /  \
 *   2    2
 *  / \  / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *   1
 *  / \
 * 2   2
 *  \   \
 *  3    3
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * Related Topics 树 深度优先搜索 广度优先搜索
 */
public class P101_SymmetricTree_对称二叉树{
  public static void main(String[] args) {
       Solution solution = new P101_SymmetricTree_对称二叉树().new Solution();
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(2);
       root.left.left = new TreeNode(3);
       root.left.right = new TreeNode(4);
       root.right.left = new TreeNode(4);
       root.right.right = new TreeNode(3);
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      public boolean isSymmetric(TreeNode root) {
          if (root == null || (root.left == null && root.right == null)) {
              return true;
          }
          LinkedList<TreeNode> queue = new LinkedList();
          queue.add(root.left);
          queue.add(root.right);
          while (!queue.isEmpty()) {
              TreeNode left = queue.removeFirst();
              TreeNode right = queue.removeFirst();
              if (left == null && right == null) {
                  continue;
              }
              if (left == null || right == null) {
                  return false;
              }
              if (left.val != right.val) {
                  return false;
              }
              queue.add(left.left);
              queue.add(right.right);
              queue.add(left.right);
              queue.add(right.left);
          }
          return true;
      }
  }
  //leetcode submit region end(Prohibit modification and deletion)

  // 方法1：深度遍历, 执行耗时:0 ms,击败了100.00% 的Java用户
  public static boolean isSymmetric01(TreeNode root) {
    if (root == null) {
        return true;
    }
    return dfs(root.left, root.right);
  }

  public static boolean dfs(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
        return true;
    }
    if (left == null || right == null) {
        return false;
    }
    if (left.val != right.val) {
        return false;
    }
    return dfs(left.left, right.right) && dfs(left.right, right.left);
  }

  // 方法2：广度优先, 执行耗时:1 ms,击败了29.17% 的Java用户
  public static boolean isSymmetric02(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
        return true;
    }
    LinkedList<TreeNode> queue = new LinkedList();
    queue.add(root.left);
    queue.add(root.right);
    while (!queue.isEmpty()) {
        TreeNode left = queue.removeFirst();
        TreeNode right = queue.removeFirst();
        if (left == null && right == null) {
           continue;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        queue.add(left.left);
        queue.add(right.right);
        queue.add(left.right);
        queue.add(right.left);
    }
    return true;
  }

}