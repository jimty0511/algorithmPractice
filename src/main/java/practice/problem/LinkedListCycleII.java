package practice.problem;

import practice.domain.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode walker = head, runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                runner = head;
                while (walker != runner) {
                    walker = walker.next;
                    runner = runner.next;
                }
                return runner;
            }
        }
        return null;
    }
}
