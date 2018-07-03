package practice.problem;

import practice.domain.RandomListNode;

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
}
