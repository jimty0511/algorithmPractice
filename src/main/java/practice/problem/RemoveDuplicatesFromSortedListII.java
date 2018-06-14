package practice.problem;

import practice.domain.ListNode;

// 82. Remove Duplicates from Sorted List II
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicatesTwo(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int tempVal = node.next.val;
                while (node.next != null && node.next.val == tempVal) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }
}
