package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 623. Add One Row to Tree
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 0; i < d - 2; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode tmp = node.left;
            node.left = new TreeNode(v);
            node.left.left = tmp;
            tmp = node.right;
            node.right = new TreeNode(v);
            node.right.right = tmp;
        }
        return root;
    }
}
