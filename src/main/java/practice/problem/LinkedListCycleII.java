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

    public ListNode detectCycleTwo(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public ListNode detectCycleThree(ListNode head) {
        // write your code here
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
