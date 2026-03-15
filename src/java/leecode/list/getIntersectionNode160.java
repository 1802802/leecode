package leecode.list;

import java.util.HashSet;
import java.util.Set;

public class getIntersectionNode160 {
    /*
    最简单的做法，把headA的节点都存下来，然后再去headB里去找
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> headAMap = new HashSet<>();
        ListNode nextNode = headA;
        while (nextNode != null) {
            headAMap.add(nextNode);
            nextNode = nextNode.next;
        }

        nextNode = headB;
        while (nextNode != null) {
            if (headAMap.contains(nextNode)) {
                return nextNode;
            } else {
                nextNode = nextNode.next;
            }
        }
        return null;
    }

    /*
    双指针法有个本质，就是如果两个链表有交点，那么一个指针走两趟链表时他们就会相交。否则最后就都是null
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode firstNode = headA;
        ListNode secondNode = headB;
        while (firstNode != secondNode) {
            firstNode = firstNode != null ? firstNode.next : headB;
            secondNode = secondNode != null ? secondNode.next : headA;
        }
        return firstNode;
    }
}
