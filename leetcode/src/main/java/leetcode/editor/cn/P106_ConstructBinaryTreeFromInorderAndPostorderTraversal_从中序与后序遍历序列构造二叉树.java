package leetcode.editor.cn;

import common.node.TreeNode;
import sun.awt.windows.WingDings;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * Related Topics 树 深度优先搜索 数组
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal_从中序与后序遍历序列构造二叉树().new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        solution.buildTree(inorder, postorder);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return recur(map, inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode recur(Map<Integer, Integer> map, int[] inorder, int[] postorder, int pEnd, int start, int end) {
            if (start > end || pEnd < 0) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[pEnd]);
            int index = map.get(postorder[pEnd]);
            root.right = recur(map, inorder, postorder, pEnd - 1, index + 1, end);
            root.left = recur(map, inorder, postorder, pEnd - (end - index + 1), start, index - 1);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 执行耗时:3 ms,击败了73.73% 的Java用户
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(map, inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode recur(Map<Integer, Integer> map, int[] inorder, int[] postorder, int pEnd, int start, int end) {
        if (start > end || pEnd < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        int index = map.get(postorder[pEnd]);
        root.right = recur(map, inorder, postorder, pEnd - 1, index + 1, end);
        root.left = recur(map, inorder, postorder, pEnd - (end - index + 1), start, index - 1);
        return root;
    }

}