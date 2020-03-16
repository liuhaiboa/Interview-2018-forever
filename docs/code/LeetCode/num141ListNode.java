package LeetCode;

/**
 *
 * 给定一个链表，判断链表中是否有环
 */
public class num141ListNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**、
     * 双指针（快慢指针）
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }
}
