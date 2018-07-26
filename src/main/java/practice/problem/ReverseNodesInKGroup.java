package practice.problem;

import practice.domain.ListNode;

// 25. Reverse Nodes in k-Group
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
            cur = pre.next;
        }
        return dummy.next;
    }
}
