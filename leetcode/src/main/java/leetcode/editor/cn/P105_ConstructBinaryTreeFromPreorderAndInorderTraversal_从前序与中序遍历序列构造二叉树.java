package leetcode.editor.cn;

import common.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i=0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return recur(map, preorder, inorder, 0, 0, inorder.length - 1);
        }

        public TreeNode recur(Map<Integer, Integer> map, int[] preorder, int[] inorder, int pStart, int start, int end) {
            if (start > end || pStart > preorder.length - 1) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pStart]);
            int index = map.get(preorder[pStart]);
            root.left = recur(map, preorder, inorder, pStart + 1, start, index - 1);
            root.right = recur(map, preorder, inorder, pStart + (index - start) + 1, index + 1, end);
            return root;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 方法1：递归
    // 执行耗时:4 ms,击败了52.28% 的Java用户
    public static TreeNode buildTree01(int[] preorder, int[] inorder) {
        return recur01(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode recur01(int[] preorder, int[] inorder, int pStart, int start, int end) {
        if (start > end || pStart > preorder.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = getIndex(preorder[pStart], inorder, start, end);

        root.left = recur01(preorder, inorder, pStart + 1, start, index - 1);
        root.right = recur01(preorder, inorder, pStart + (index - start) + 1, index + 1, end);
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

    // 方法2：在方法1的基础上使用缓存。把中序遍历的每个值和下标存到map中对应起来
    // 执行耗时:2 ms,击败了98.14% 的Java用户
    public static TreeNode buildTree02(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur02(map, preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode recur02(Map<Integer, Integer> map, int[] preorder, int[] inorder, int pStart, int start, int end) {
        if (start > end || pStart > preorder.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = map.get(preorder[pStart]);
        root.left = recur02(map, preorder, inorder, pStart + 1, start, index - 1);
        root.right = recur02(map, preorder, inorder, pStart + (index - start) + 1, index + 1, end);
        return root;
    }

}