package leecode.list;

import java.util.HashSet;
import java.util.Set;

public class detectCycle142 {
    /*
    还是最经典的set法
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    /*
    这里的核心是，要理解，计算首个入环节点时，快慢指针的起点要保持一致。
    之后快慢指针一起后，再从初始位置开始，走一个指针和slow一起，他们相遇的地方就是环起点
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        } else {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (slow == fast) {
                    ListNode ptr = head;
                    while (slow != ptr) {
                        slow = slow.next;
                        ptr = ptr.next;
                    }
                    return ptr;
                }
            }
        }
        return null;
    }
}
