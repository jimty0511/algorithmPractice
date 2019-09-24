package practice.domain;

import java.util.Stack;

// 430. Flatten a Multilevel Doubly Linked List
public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null)
            return null;
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node temp = p.child;
            while (temp.next != null)
                temp = temp.next;
            temp.next = p.next;
            if (p.next != null)
                p.next.prev = temp;
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }

    public Node flattenStack(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            if (cur.child != null) {
                stack.push(cur.next);
                cur.next = cur.child;
                if (cur.next != null)
                    cur.next.prev = cur;
                cur.child = null;
            } else if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                if (cur.next != null)
                    cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

