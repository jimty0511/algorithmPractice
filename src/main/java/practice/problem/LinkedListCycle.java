package practice.problem;

import practice.domain.ListNode;

// 141. Linked List Cycle
// Microsoft ladder
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode walker = head, runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner)
                return true;
        }
        return false;
    }

    public boolean hasCycleTwo(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
