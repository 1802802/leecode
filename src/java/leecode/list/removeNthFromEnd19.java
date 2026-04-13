package leecode.list;

import java.util.ArrayList;
import java.util.List;

public class removeNthFromEnd19 {
    /*
    很传统的写法，不过用栈或者双指针会更优雅
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode baseHead = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        int removeIndex = listNodes.size() - n;
        if (removeIndex >= 1 && removeIndex < listNodes.size()) {
            if (removeIndex + 1 < listNodes.size()) {
                listNodes.get(removeIndex - 1).next = listNodes.get(removeIndex + 1);
            } else {
                listNodes.get(removeIndex - 1).next = null;
            }
            return baseHead;
        } else if (removeIndex == 0 && listNodes.size() > 1) {
            return listNodes.get(1);
        } else if (listNodes.size() == 1) {
            return null;
        } else {
            return baseHead;
        }
    }

    /*
    双指针法
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode beforeHead = new ListNode(0, head);
        ListNode first = head;
        ListNode second = beforeHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        if (second != null && second.next != null) {
            second.next = second.next.next;
        }
        return beforeHead.next;
    }
}
