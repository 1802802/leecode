package leecode.list;

import java.util.HashSet;

public class hasCycle141 {
    /*
    这个是最经典的写法，用set存出现的数据，然后挨个判断
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /*
    这个是快慢指针，核心思路是，如果有环则快慢指针必定相遇，否则就是快指针先到头
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        } else {
            ListNode slow = head;
            ListNode fast = head.next;
            while (!slow.equals(fast)) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }
}
