package Template;

import java.util.Stack;

public class DFS {
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

        dfs02(tree);
    }

    // 递归版深度优先遍历树
    public static void dfs01(TreeNode node) {
        // 1. 递归终止条件
        if(node==null) return;

        // 2. 处理当前层逻辑
        System.out.println(node.val);

        // 3. 下挖一层
        dfs01(node.left);
        dfs01(node.right);
        // 4. 恢复状态
    }

    // 非递归版深度优先遍历树
    public static void dfs02(TreeNode root) {
        // 创建一个栈辅助遍历
        Stack<TreeNode> stack = new Stack<>();
        // 把根节点放入栈
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }

}

