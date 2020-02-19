package practice.problem;

import practice.domain.ListNode;

// 25. Reverse Nodes in k-Group
// Microsoft ladder
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode c = head;
        while (c != null) {
            c = c.next;
            n++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy.next;
        for (int i = n; i >= k; i -= k) {
            for (int j = 1; j < k; j++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroupTwo(ListNode head, int k) {
        ListNode dummy = new ListNode(0), start = dummy;
        dummy.next = head;
        while (true) {
            ListNode pre = start, cur, next = pre;
            start = pre.next;
            for (int i = 0; i < k && next != null; i++)
                next = next.next;
            if (next == null)
                break;
            for (int i = 0; i < k - 1; i++) {
                cur = pre.next;
                pre.next = cur.next;
                cur.next = next.next;
                next.next = cur;
            }
        }
        return dummy.next;
    }

    public ListNode reverseKGroupThree(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (true) {
            head = reverseK(head, k);
            if (head == null)
                break;
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode head, int k) {
        ListNode nodeK = head;
        for (int i = 0; i < k; i++) {
            if (nodeK == null)
                return null;
            nodeK = nodeK.next;
        }
        if (nodeK == null)
            return null;
        ListNode nodeOne = head.next, nextPart = nodeK.next;
        ListNode pre = null, cur = nodeOne;
        while (cur != nextPart) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = nodeK;
        nodeOne.next = nextPart;
        return nodeOne;
    }
}
