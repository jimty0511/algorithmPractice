package practice.lintcode;

import practice.domain.ListNode;

// 219. Insert Node in Sorted Linked List
public class InsertNodeInSortedLinkedList {
    /**
     * @param head: The head of linked list.
     * @param val:  An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        ListNode node = new ListNode(val);
        if (head == null)
            return node;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.val < val) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return dummy.next;
    }
}
