package practice.problem;

import java.util.Stack;

// 426. Convert Binary Search Tree to Sorted Doubly Linked List
// Microsoft ladder
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node first = null, last = null;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null)
                first = root;
            if (last != null) {
                last.right = root;
                root.left = last;
            }
            last = root;
            root = root.right;
        }
        first.left = last;
        last.right = first;
        return first;
    }

    Node prev = null;

    public Node treeToDoublyListTwo(Node root) {
        if (root == null)
            return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(Node curr) {
        if (curr == null)
            return;
        helper(curr.left);
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        helper(curr.right);
    }
}
