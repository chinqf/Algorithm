package leetcode.editor.cn;

/**
 * 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * Related Topics 链表
 *
 * 解法1：对每个ListNode先取到下一个ListNode，然后再改变指针方向。时间复杂度 O(n)，空间复杂度 O(1)
 * 解法2：递归
 */
public class P206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    public static ListNode reverseList01(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode currTmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = currTmp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}