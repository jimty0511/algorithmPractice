package practice.problem;

import practice.domain.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

// 23. Merge k Sorted Lists
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, (l1, l2) -> Integer.compare(l1.val, l2.val));
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) {
            if (node != null)
                heap.offer(node);
        }
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null)
                heap.offer(tail.next);
        }
        return head.next;
    }
}
