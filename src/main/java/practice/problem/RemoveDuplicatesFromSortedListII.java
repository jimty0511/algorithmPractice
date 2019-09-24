package practice.problem;

import practice.domain.ListNode;

// 82. Remove Duplicates from Sorted List II
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, pre = dummy;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next != curr) {
                pre.next = curr.next;
                curr = pre.next;
            } else {
                pre = pre.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
