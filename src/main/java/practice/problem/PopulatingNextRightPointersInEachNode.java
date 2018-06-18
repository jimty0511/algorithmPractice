package practice.problem;

import practice.domain.TreeLinkNode;

// 116. Populating Next Right Pointers in Each Node
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }
}
