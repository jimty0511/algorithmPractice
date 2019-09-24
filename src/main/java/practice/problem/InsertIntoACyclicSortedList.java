package practice.problem;

import practice.domain.ListNode;

// 708 Insert into a Cyclic Sorted List (599 LC)
public class InsertIntoACyclicSortedList {
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        ListNode head = node;
        while (node != null && node.next != null) {
            if (node.val < node.next.val) {
                if (node.val <= x && x <= node.next.val) {
                    insertNode(node, x);
                    break;
                }
            } else if (node.val > node.next.val) {
                if (node.val < x || x < node.next.val) {
                    insertNode(node, x);
                    break;
                }
            } else {
                if (node.next == head) {
                    insertNode(node, x);
                    break;
                }
            }
            node = node.next;
        }
        return head;
    }

    private void insertNode(ListNode node, int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = node.next;
        node.next = newNode;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node cur = new Node(insertVal, null);
            cur.next = cur;
            return cur;
        }
        Node prev = head, cur = head.next;
        while (cur != head) {
            int preVal = prev.val;
            int curVal = cur.val;
            if (insertVal == preVal || (preVal < insertVal && insertVal <= curVal) ||
                    (preVal < insertVal && curVal < preVal) || (insertVal < curVal && curVal < preVal))
                break;
            prev = cur;
            cur = cur.next;
        }
        Node node = new Node(insertVal, null);
        prev.next = node;
        node.next = cur;
        return head;
    }

}
