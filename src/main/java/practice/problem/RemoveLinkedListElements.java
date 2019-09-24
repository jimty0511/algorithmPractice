package practice.problem;

import practice.domain.ListNode;

// 203. Remove Linked List Elements
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head.val == val ? head.next : head;
    }
}
