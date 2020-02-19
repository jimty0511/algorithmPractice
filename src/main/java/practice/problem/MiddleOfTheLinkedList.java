package practice.problem;

import practice.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

// Middle of Linked List
// Microsoft ladder
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNodeTwo(ListNode head) {
        // write your code here
        if (head == null)
            return null;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (list.size() % 2 == 0)
            return pre;
        else
            return slow;
    }
}
