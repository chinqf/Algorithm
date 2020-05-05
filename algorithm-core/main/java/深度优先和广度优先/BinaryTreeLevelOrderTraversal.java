package 深度优先和广度优先;

import Template.TreeNode;

import java.util.*;

/** 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按层序遍历得到的节点值。(即逐层地，从左到右访问所有节点)。
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
 *   [9,20],
 *   [15,7]
 * ]
 */
// 难点：遍历结果得一层一层分开
// 思路1：广度优先遍历，设置level，每一层处理完再处理下一层
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        System.out.println(levelOrder01(tree));
    }


    // 使用广度优先遍历
    public static List<List<Integer>> levelOrder01(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int level = 0;

        TreeNode node = null;
        while(!deque.isEmpty()) {
            ans.add(new ArrayList<Integer>());
            // 队列的长度就是当前层node的个数
            int size = deque.size();
            for(int i=0; i<size; i++){
                node = deque.removeFirst();
                ans.get(level).add(node.val);
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            level++;
        }
        return ans;
    }

}


