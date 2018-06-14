package practice.problem;

import practice.domain.ListNode;

// Cracking page 213
// 86. Partition List
public class PartitionList {
    public ListNode partition(ListNode node, int x) {
        ListNode head = node, tail = node;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public ListNode partitionLC(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}
