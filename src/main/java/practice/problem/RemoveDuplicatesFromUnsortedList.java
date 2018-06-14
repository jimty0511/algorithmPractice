package practice.problem;

import practice.domain.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Remove Duplicates from Unsorted List
public class RemoveDuplicatesFromUnsortedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        Map<Integer, Boolean> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        map.put(curr.val, true);
        set.add(curr.val);
        while (curr.next != null) {
            if (!set.add(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                set.add(curr.next.val);
                curr = curr.next;
            }
        }
        return head;
    }
}
