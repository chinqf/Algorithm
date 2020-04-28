import java.util.List;

/** 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode ans = mergeTwoLists(l1, l2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode prev = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        while (l1 != null) {
            prev.next = l1;
            l1 = l1.next;
            prev = prev.next;
        }
        while (l2 != null) {
            prev.next = l2;
            l2 = l2.next;
            prev = prev.next;
        }
        return ans.next;
    }
}
