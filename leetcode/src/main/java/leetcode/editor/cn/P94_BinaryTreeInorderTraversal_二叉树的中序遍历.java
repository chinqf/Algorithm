package leetcode.editor.cn;
import common.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Related Topics 栈 树 哈希表
 */
public class P94_BinaryTreeInorderTraversal_二叉树的中序遍历 {
    public static void main(String[] args) {
        Solution solution = new P94_BinaryTreeInorderTraversal_二叉树的中序遍历().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // 创建栈辅助遍历
            Stack<TreeNode> stack = new Stack();
            List<Integer> result = new ArrayList<Integer>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    result.add(root.val);
                    root = root.right;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：递归
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    static List<Integer> res = new ArrayList<Integer>();
    public static List<Integer> inorderTraversal01(TreeNode root) {
        dfs(root);
        return res;
    }
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    // 方法2：使用栈
    // 执行耗时:1 ms,击败了49.46% 的Java用户
    public static List<Integer> inorderTraversal02(TreeNode root) {
        // 创建栈辅助遍历
        Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList<Integer>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }


}