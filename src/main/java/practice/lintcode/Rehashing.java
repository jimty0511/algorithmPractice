package practice.lintcode;

import practice.domain.ListNode;

// 129. Rehashing
public class Rehashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable.length <= 0)
            return hashTable;
        int newCap = 2 * hashTable.length;
        ListNode[] res = new ListNode[newCap];
        for (int i = 0; i < hashTable.length; i++) {
            while (hashTable[i] != null) {
                int newIdx = (hashTable[i].val % newCap + newCap) % newCap;
                if (res[newIdx] == null) {
                    res[newIdx] = new ListNode(hashTable[i].val);
                } else {
                    ListNode dummy = res[newIdx];
                    while (dummy.next != null)
                        dummy = dummy.next;
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return res;
    }
}
