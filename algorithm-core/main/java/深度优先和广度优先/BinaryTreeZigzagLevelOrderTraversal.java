package 深度优先和广度优先;

import common.node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 示例：
 * 二叉树: [3,9,20,null,null,15,7]
 *    3
 *   / \
 *  9  20
 *    / \
 *   15  7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);

        System.out.println(zigzagLevelOrder(tree));

    }

    // 广度优先遍历
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        int level = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        TreeNode node = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(new ArrayList<>());
            for(int i=0; i<size; i++) {
                if(level%2==0) {
                    node = queue.removeFirst();
                    ans.get(level).add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                } else {
                    node = queue.removeLast();
                    ans.get(level).add(node.val);
                    if(node.right != null) queue.addFirst(node.right);
                    if(node.left != null) queue.addFirst(node.left);
                }
            }
            level++;
        }
        return ans;
    }
}
