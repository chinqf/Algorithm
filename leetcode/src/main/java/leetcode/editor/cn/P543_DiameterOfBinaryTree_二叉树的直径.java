package leetcode.editor.cn;

import common.node.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * Related Topics 树
 */
public class P543_DiameterOfBinaryTree_二叉树的直径 {
    public static void main(String[] args) {
        Solution solution = new P543_DiameterOfBinaryTree_二叉树的直径().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    class Solution {
        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            maxDepth(root);
            return ans - 1;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left =maxDepth(root.left);
            int right = maxDepth(root.right);
            ans = Math.max(ans, left + right + 1);
            return Math.max(left, right) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}