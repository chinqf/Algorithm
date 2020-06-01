package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;

/**环形链表2
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * Related Topics 链表 双指针
 *
 * 解法1：用HashSet保存遍历过的节点，在HashSet中出现过的第一个节点就是链表开始入环的第一个节点
 * 解法2：第一步先用快慢指针找到相遇点；第二步设置一个指针指向链表头，一个指针指向相遇点，然后两个点都往前一步一步走，相遇的时候则得到结果
 * 原理：
 * slow: 慢节点，fast: 快节点
 * a: 链表头到结果节点，b: 结果节点到相遇节点，c:相遇节点到结果节点
 * 2*distance(slow) = distance(fast)
 * 2*(a+b) = a + b + c + b
 * a = c
 */
public class P142_LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142_LinkedListCycleIi().new Solution();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(solution.detectCycle(node1).val);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head.next;
            ListNode fast = head.next.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            while (head != slow) {
                head = head.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static ListNode detectCycle01(ListNode head) {
            HashSet<ListNode> set = new HashSet();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                }
                set.add(head);
                head = head.next;
            }
            return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}