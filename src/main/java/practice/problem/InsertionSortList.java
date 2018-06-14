package practice.problem;

import practice.domain.ListNode;

// 147. Insertion Sort List
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return dummy.next;
    }
}
