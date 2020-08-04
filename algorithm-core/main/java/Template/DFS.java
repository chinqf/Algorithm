package Template;

import java.util.Stack;

/** 深度优先遍历树
 * 有递归版和非递归版
 * 深度优先遍历树又可分为先序遍历、中序遍历、后序遍历
 *
 */
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



    // 递归版深度优先遍历树(先序遍历)
    public static void dfs01(TreeNode node) {
        // 1. 递归终止条件
        if(node==null) return;
        // 2. 处理当前层逻辑
        System.out.println(node.val);
        // 3. 下挖一层
        dfs01(node.left);
        dfs01(node.right);
    }
    // 递归版深度优先遍历树(中序遍历)
    public static void dfs02(TreeNode node) {
        if(node==null) return;
        dfs02(node.left);
        System.out.println(node.val);
        dfs02(node.right);
    }
    // 递归版深度优先遍历树(后序遍历)
    public static void dfs03(TreeNode node) {
        if(node==null) return;
        dfs03(node.left);
        dfs03(node.right);
        System.out.println(node.val);
    }


    // 非递归版深度优先遍历树(先序遍历)
    public static void dfs04(TreeNode root) {
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


    // 非递归版深度优先遍历树(中序遍历)
    public static void dfs05(TreeNode node) {
        // 创建一个栈辅助遍历
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node!=null) {
            if(node!=null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    // 非递归版深度优先遍历树(后序遍历 — 双栈)
    public static void dfs06(TreeNode node) {
        Stack<TreeNode> stack01 = new Stack<>();
        Stack<TreeNode> stack02 = new Stack<>();
        stack01.push(node);
        while(!stack01.isEmpty()) {
            node = stack01.pop();
            stack02.push(node);
            if(node.left != null) stack01.push(node.left);
            if(node.right != null) stack01.push(node.right);
        }
        while(!stack02.isEmpty()) {
            System.out.println(stack02.pop().val);
        }
    }

}

