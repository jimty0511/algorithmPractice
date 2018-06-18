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
}
