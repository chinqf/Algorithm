package Template;

import common.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {
    public static void main(String[] args) {
        // 构造树: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.left.right = new TreeNode(5);
        tree.left.right.left = new TreeNode(10);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        bfs(tree);
    }

    public static void bfs(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            System.out.println(node.val);
            if(node.left!=null) queue.addLast(node.left);
            if(node.right!=null) queue.addLast(node.right);
        }
    }
}
