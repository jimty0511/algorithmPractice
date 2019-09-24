package practice.problem;

import practice.domain.RandomListNode;

import java.util.HashMap;
import java.util.Map;

// 138. Copy List with Random Pointer
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode sec = new RandomListNode(cur.label);
            sec.next = cur.next;
            cur.next = sec;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode res = head.next;
        RandomListNode sec = res;
        while (sec.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            sec.next = sec.next.next;
            sec = sec.next;
        }
        cur.next = cur.next.next;

        return res;
    }

    public RandomListNode copyRandomListTwo(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
