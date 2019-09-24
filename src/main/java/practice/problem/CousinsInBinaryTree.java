package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 993. Cousins in Binary Tree
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.val == x)
                    foundX = true;
                if (cur.val == y)
                    foundY = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y)
                        return false;
                    if (cur.right.val == x && cur.left.val == y)
                        return false;
                }
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            if (foundX && foundY)
                return true;
        }
        return false;
    }
}
