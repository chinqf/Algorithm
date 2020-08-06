package leetcode.editor.cn;

import common.node.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *   3
 *  / \
 * 9  20
 *   /  \
 * 15   7
 * Related Topics 树 深度优先搜索 数组
 */
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal_从前序与中序遍历序列构造二叉树().new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        solution.buildTree(preorder, inorder);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return recur(preorder, inorder, 0, 0, inorder.length - 1);
        }

        public TreeNode recur(int[] preorder, int[] inorder, int pStart, int start, int end) {
            if (pStart > preorder.length - 1 ||start > end) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pStart]);
            int index = getIndex(preorder[pStart], inorder, start, end);
            root.left = recur(preorder, inorder, pStart + 1, start, index - 1);
            root.right = recur(preorder, inorder, pStart + index - start + 1,index + 1, end);
            return root;
        }

        public int getIndex(int pre, int[] inorder, int start, int end) {
            for (int i = start; i <= end; i++) {
                if (inorder[i] == pre) {
                    return i;
                }
            }
            return -1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 根据前序遍历的顺序来区分左子树还是右子树
    public static TreeNode buildTree01(int[] preorder, int[] inorder) {
        return recur(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode recur(int[] preorder, int[] inorder, int pIndex, int start, int end) {
        if (start > end || start < 0 || end < 0 ) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pIndex]);
        int index = getIndex(preorder[pIndex], inorder, start, end);
        pIndex ++;
        root.left = recur(preorder, inorder, pIndex, start, index - 1);
        root.right = recur(preorder, inorder, pIndex, index + 1, end);
        return root;
    }

    public static int getIndex(int pre, int[] inorder, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == pre) {
                return i;
            }
        }
        return -1;
    }

}