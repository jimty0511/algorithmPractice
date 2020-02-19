package practice.lintcode;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 1704. Range Sum of BST
public class RangeSumOfBST {
    /**
     * @param root: the root node
     * @param L:    an integer
     * @param R:    an integer
     * @return: the sum
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        // write your code here.
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.val >= L && node.val <= R)
                    sum += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return sum;
    }

    int res = 0;

    public int rangeSumBSTTwo(TreeNode root, int L, int R) {
        helper(root, L, R);
        return res;
    }

    private void helper(TreeNode root, int L, int R) {
        if (root != null) {
            if (root.val >= L && root.val <= R)
                res += root.val;
            if (L < root.val)
                helper(root.left, L, R);
            if (R > root.val)
                helper(root.right, L, R);
        }
    }
}
