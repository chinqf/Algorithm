import java.util.*;

/** 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */


public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {

    }

    // 使用父指针迭代
    // 如果每个节点都有父指针，那么可以从p和q回溯以获取它们的公共祖先。在这个遍历过程中，我们得到的第一个公共节点是LCA节点
    // 所以可以考虑在遍历树时将父指针保存在字典中
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历树的时候需要用到的栈
        Deque<TreeNode> stack = new ArrayDeque<>();

        // 存储父指针的map
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        // 遍历树直到找到p和q
        while(!parent.containsKey(p)||!parent.containsKey(q)) {
            TreeNode node = stack.pop();
            // 遍历树的时候存储父指针
            if(node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // 存储p节点的祖先
        Set<TreeNode> ancestors = new HashSet<>();
        while (p!=null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // q回溯时候的第一个祖先如果出现在p祖先中则是它们最近的公共祖先
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }


}