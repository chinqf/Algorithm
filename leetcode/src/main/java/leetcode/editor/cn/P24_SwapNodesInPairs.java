package leetcode.editor.cn;

/** 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * Related Topics 链表
 *
 */
public class P24_SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24_SwapNodesInPairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 递归版
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 需要交换的两个Node
            ListNode first = head;
            ListNode second = head.next;

            // 交换两个Node
            first.next = swapPairs(second.next);
            second.next = first;

            return second;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    // 非递归版
    public static ListNode swapPairs01(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            // 记录要交换的两个节点
            ListNode first = head;
            ListNode second = head.next;

            // 交换两个节点
            pre.next = second;
            first.next = second.next;
            second.next = first;

            // 往下跳
            pre = first;
            head = first.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}