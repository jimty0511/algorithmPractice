package practice.domain;

// 705. Design HashSet
public class DesignHashSet {

//    private int bucket = 1000;
//    private int itemPerBucket = 1001;
//    private boolean[][] table;
//
//    public DesignHashSet() {
//        table = new boolean[bucket][];
//    }
//
//    private int hash(int key) {
//        return key % bucket;
//    }
//
//    private int pos(int key) {
//        return key / bucket;
//    }
//
//    public void add(int key) {
//        int hashKey = hash(key);
//        if (table[hashKey] == null)
//            table[hashKey] = new boolean[itemPerBucket];
//        table[hashKey][pos(key)] = true;
//    }
//
//    public void remove(int key) {
//        int hashKey = hash(key);
//        if (table[hashKey] != null)
//            table[hashKey][pos(key)] = false;
//    }
//
//    /**
//     * Returns true if this set contains the specified element
//     */
//    public boolean contains(int key) {
//        int hashKey = hash(key);
//        return table[hashKey] != null && table[hashKey][pos(key)];
//    }

    class ListNode {
        int key;
        ListNode next;

        public ListNode(int key) {
            this.key = key;
        }
    }

    ListNode[] bucket;

    public DesignHashSet() {
        bucket = new ListNode[1000];
    }

    private int hash(int key) {
        return Integer.hashCode(key) % bucket.length;
    }

    public void add(int key) {
        int hash = hash(key);
        if (bucket[hash] == null)
            bucket[hash] = new ListNode(key);
        else {
            ListNode node = bucket[hash];
            while (node.next != null) {
                if (node.key == key)
                    return;
                node = node.next;
            }
            if (node.key == key)
                return;
            node.next = new ListNode(key);
        }
    }

    public void remove(int key) {
        int hash = hash(key);
        ListNode node = bucket[hash], prev = null;
        if (node != null) {
            while (node != null) {
                if (node.key == key) {
                    if (prev == null) {
                        bucket[hash] = node.next;
                        return;
                    } else {
                        prev.next = node.next;
                        return;
                    }
                }
                prev = node;
                node = node.next;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = hash(key);
        ListNode node = bucket[hash];
        while (node != null) {
            if (node.key == key)
                return true;
            node = node.next;
        }
        return false;
    }
}
