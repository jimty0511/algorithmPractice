package practice.problem;

import practice.domain.ListNode;

import java.util.Stack;

// 445. Add Two Numbers II
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode dummy = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            dummy.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = dummy;
            dummy = head;
            sum /= 10;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }

}
