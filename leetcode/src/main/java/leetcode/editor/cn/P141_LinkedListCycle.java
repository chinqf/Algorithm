package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 * Related Topics 链表 双指针
 * <p>
 * 解法1：使用映射表存储节点，如果节点在映射表中出现过则返回True
 * 解法2：使用快慢指针，快指针一次走2步，慢指针一次走1步，如果存在环则快慢指针会相遇，没有环则快指针先到末尾
 */
public class P141_LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141_LinkedListCycle().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 解法1
    public static boolean hasCycle01(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}