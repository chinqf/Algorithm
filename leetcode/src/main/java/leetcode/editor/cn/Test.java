package leetcode.editor.cn;

import common.node.TreeNode;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(null);
        System.out.println(queue.size());
        System.out.println(queue.removeFirst());
    }
}
