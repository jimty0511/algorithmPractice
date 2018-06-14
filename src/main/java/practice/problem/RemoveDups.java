package practice.problem;

import practice.domain.ListNode;

// Cracking page 208
public class RemoveDups {
    public void removeDups(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
