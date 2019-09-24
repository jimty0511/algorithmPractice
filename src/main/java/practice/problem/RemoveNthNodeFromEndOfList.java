package practice.problem;

import practice.domain.ListNode;

// 19. Remove Nth Node From End of List
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy, fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            start = start.next;
            fast = fast.next;
        }
        start.next = start.next.next;
        return dummy.next;
    }
}
