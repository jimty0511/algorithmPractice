package practice.problem;

import practice.domain.ListNode;

import java.util.HashSet;
import java.util.Set;

// 817. Linked List Components
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val)))
                res++;
            head = head.next;
        }
        return res;
    }
}
