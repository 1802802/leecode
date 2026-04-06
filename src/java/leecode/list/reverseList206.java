package leecode.list;

public class reverseList206 {
    /*
    这题的核心是理解清楚递归，当前节点的next的next设置成当前节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        if (head != null && head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
        }
        return newHead;
    }
}
