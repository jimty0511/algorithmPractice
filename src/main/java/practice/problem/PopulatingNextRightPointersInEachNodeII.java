package practice.problem;

import practice.domain.TreeLinkNode;

// 117. Populating Next Right Pointers in Each Node II
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode temp = new TreeLinkNode(0);
            TreeLinkNode cur = temp;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = temp.next;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Node newRoot = root;
        while (newRoot != null) {
            Node tmp = new Node(0, null, null, null);
            Node cur = tmp;
            while (newRoot != null) {
                if (newRoot.left != null) {
                    cur.next = newRoot.left;
                    cur = cur.next;
                }
                if (newRoot.right != null) {
                    cur.next = newRoot.right;
                    cur = cur.next;
                }
                newRoot = newRoot.next;
            }
            newRoot = tmp.next;
        }
        return root;
    }
}
