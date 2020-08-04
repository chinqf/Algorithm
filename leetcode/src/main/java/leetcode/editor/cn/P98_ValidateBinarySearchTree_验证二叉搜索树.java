package leetcode.editor.cn;

import common.node.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *   2
 *  / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *      5
 *     / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * Related Topics 树 深度优先搜索
 */
public class P98_ValidateBinarySearchTree_验证二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new P98_ValidateBinarySearchTree_验证二叉搜索树().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            double last = - Double.MAX_VALUE;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (root.val <= last) {
                        return false;
                    }
                    last = root.val;
                    root = root.right;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方案1: 递归
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    public static boolean isValidBST01(TreeNode root) {
        return dfs(root, null, null);
    }

    public static boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        int curr = root.val;
        if ((min != null && curr <= min) || (max != null && curr >= max)) {
            return false;
        }
        if (!dfs(root.left, min, curr) ) {
            return false;
        }
        if (!dfs(root.right, curr, max)) {
            return false;
        }
        return true;
    }

    // 方法2: 迭代中序遍历，如果中序遍历得到的节点值 <= 前面的节点值，则返回 false
    // 执行耗时:2 ms,击败了32.85% 的Java用户
    public static boolean isValidBST02(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        int last = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= last) {
                    return false;
                }
                last = root.val;
                root = root.right;
            }
        }
        return true;
    }

}