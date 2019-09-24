package practice.domain;

import java.util.Random;

// 382. Linked List Random Node
public class LinkedListRandomNode {

    ListNode head;
    Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode cur = this.head;
        int r = cur.val;
        for (int i = 1; cur.next != null; i++) {
            cur = cur.next;
            if (random.nextInt(i + 1) == i)
                r = cur.val;
        }
        return r;
    }

    public int getRandomTwo() {
        ListNode cur = head;
        int count = 0, res = 0;
        while (cur != null) {
            int ran = random.nextInt(count + 1);
            if (ran == count)
                res = cur.val;
            count++;
            cur = cur.next;
        }
        return res;
    }
}
