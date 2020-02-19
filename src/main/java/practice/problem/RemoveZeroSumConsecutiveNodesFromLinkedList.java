package practice.problem;

import practice.domain.ListNode;

import java.util.HashMap;
import java.util.Map;

// 1171. Remove Zero Sum Consecutive Nodes from Linked List
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int preSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (cur != null) {
            preSum += cur.val;
            if (map.containsKey(preSum)) {
                cur = map.get(preSum).next;
                int tmp = preSum + cur.val;
                while (tmp != preSum) {
                    map.remove(tmp);
                    cur = cur.next;
                    tmp += cur.val;
                }
                map.get(preSum).next = cur.next;
            } else {
                map.put(preSum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
