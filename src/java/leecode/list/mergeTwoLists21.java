package leecode.list;

import java.util.ArrayList;
import java.util.List;

public class mergeTwoLists21 {
    /*
    比较基础的写法，先全部存起来，再串成列表
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        List<ListNode> list = new ArrayList<>();
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                list.add(list2);
                list2 = list2.next;
            } else if (list2 == null) {
                list.add(list1);
                list1 = list1.next;
            } else {
                if (list1.val <= list2.val) {
                    list.add(list1);
                    list1 = list1.next;
                } else {
                    list.add(list2);
                    list2 = list2.next;
                }
            }
        }
        ListNode head = null;
        if (!list.isEmpty()) {
            head = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
        }
        return head;
    }

    /*
    最经典的递归，要理解通过递归暂存每个listNode的下个节点，由此串联每个数据
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
