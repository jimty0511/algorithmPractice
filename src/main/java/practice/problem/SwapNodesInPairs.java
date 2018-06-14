package practice.problem;

import practice.domain.ListNode;

// 24. Swap Nodes in Pairs
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;           // 1,2,3,4,
            ListNode second = current.next.next;     // 2,3,4
            first.next = second.next;                // 1,3,4
            current.next = second;                   // 0,2,3,4
            current.next.next = first;               // 0,2,1,3,4
            current = current.next.next;
        }
        return dummy.next;
    }
}
