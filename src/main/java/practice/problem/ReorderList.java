package practice.problem;

import practice.domain.ListNode;

// 143. Reorder List
public class ReorderList {

    public void reorderListThreeSteps(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode preMid = slow, curr = slow.next;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = preMid.next;
            preMid.next = temp;
        }
//        slow = head;
//        fast = preMid.next;
//        while (slow != preMid) {
//            preMid.next = fast.next;
//            fast.next = slow.next;
//            slow.next = fast;
//            slow = fast.next;
//            fast = preMid.next;
//        }
        fast = preMid.next;
        preMid.next = null;
        reorderListMerge(head, fast);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode mid = reorderListFindMiddle(head);
        ListNode tail = reorderListReverse(mid.next);
        mid.next = null;
        reorderListMerge(head, tail);
    }

    private void reorderListMerge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index++;
        }
        if (head1 != null)
            dummy.next = head1;
        else
            dummy.next = head2;
    }

    private ListNode reorderListFindMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reorderListReverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
