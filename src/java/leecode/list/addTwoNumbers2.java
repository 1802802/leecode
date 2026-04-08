package leecode.list;

import java.util.*;

public class addTwoNumbers2 {
    /*
    非常old school的写法，
    先用队列存储两个list加起来的结果，
    然后用deque处理数据，将前面要递增的位次加到后面，并构建listNode，
    最后用list存储，将列表串起来
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        while (l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }
        List<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                list.add(queue2.poll());
            } else if (queue2.isEmpty()) {
                list.add(queue1.poll());
            } else {
                list.add(queue1.poll() + queue2.poll());
            }
        }

        Deque<ListNode> listNodeDeque = new ArrayDeque<>();
        int addNum = 0;
        for (Integer integer : list) {
            int actualVal = addNum + integer;
            int val = actualVal % 10;
            addNum = actualVal / 10;
            listNodeDeque.addLast(new ListNode(val));
        }
        if (addNum > 0) {
            listNodeDeque.addLast(new ListNode(addNum));
        }

        ListNode head = null;
        if (!list.isEmpty()) {
            head = listNodeDeque.peek();
            ListNode listNode = listNodeDeque.poll();
            while (listNode != null) {
                listNode.next = listNodeDeque.poll();
                listNode = listNode.next;
            }
        }
        return head;
    }

    /*
    相较于上面的优化了下，直接用deque存相加的结果并处理了，去掉了queue的部分
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<ListNode> listNodeDeque = new ArrayDeque<>();
        int addNum = 0;
        while (l1 != null || l2 != null) {
            int actualVal = addNum;
            if (l1 == null) {
                actualVal += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                actualVal += l1.val;
                l1 = l1.next;
            } else {
                actualVal = actualVal + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            int val = actualVal % 10;
            addNum = actualVal / 10;
            listNodeDeque.addLast(new ListNode(val));
        }
        if (addNum > 0) {
            listNodeDeque.addLast(new ListNode(addNum));
        }

        ListNode head = null;
        if (!listNodeDeque.isEmpty()) {
            head = listNodeDeque.peek();
            ListNode listNode = listNodeDeque.poll();
            while (listNode != null) {
                listNode.next = listNodeDeque.poll();
                listNode = listNode.next;
            }
        }
        return head;
    }

    /*
    这个更简单了，去掉了deque的部分，直接用listNode串联数据。
    不过用deque的好处是可以自由控制list的朝向，用于解决变种题目
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode listNode = null;
        int addNum = 0;
        while (l1 != null || l2 != null) {
            int actualVal = addNum;
            if (l1 == null) {
                actualVal += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                actualVal += l1.val;
                l1 = l1.next;
            } else {
                actualVal = actualVal + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            int val = actualVal % 10;
            addNum = actualVal / 10;
            if (head == null) {
                head = new ListNode(val);
                listNode = head;
            } else {
                listNode.next = new ListNode(val);
                listNode = listNode.next;
            }
        }
        if (addNum > 0) {
            listNode.next = new ListNode(addNum);
        }
        return head;
    }
}
