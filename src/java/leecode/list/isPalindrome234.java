package leecode.list;

public class isPalindrome234 {
    private ListNode frontNode;

    /*
    这个写法其实很高级，他是先用成员变量存储初始的节点，然后用递归找到列表的最后一个节点，之后逐个对比
    不过最传统的写法还是把列表变成arrayList，再用双指针从头和尾开始比较
     */
    public boolean isPalindrome(ListNode head) {
        frontNode = head;
        return checkPalindrome(head);
    }

    public boolean checkPalindrome(ListNode listNode) {
        if (listNode != null) {
            if (!checkPalindrome(listNode.next)) {
                return false;
            }
            if (listNode.val != frontNode.val) {
                return false;
            }
            frontNode = frontNode.next;
        }
        return true;
    }
}
