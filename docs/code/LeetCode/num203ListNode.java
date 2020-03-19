package LeetCode;

/**
 * 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 */
public class num203ListNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);//这是一个头结点,也可以叫做哨兵结点
        first.next = head;
        ListNode prev = first;
        ListNode current = head;
        while(current!=null) {
            if(current.val==val) {
                prev.next = current.next;
            }else {
                prev = current;
            }
            current = current.next;
        }
        return first.next;

    }
}
