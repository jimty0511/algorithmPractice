package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 958. Check Completeness of a Binary Tree
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null)
                end = true;
            else {
                if (end)
                    return false;
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return true;
    }
}
