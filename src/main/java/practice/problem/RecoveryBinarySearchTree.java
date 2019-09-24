package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 99. Recover Binary Search Tree
public class RecoveryBinarySearchTree {

    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }

    public void recoverTreeIter(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE), cur = root;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            if (first == null && prev.val >= cur.val)
                first = prev;
            if (first != null && prev.val >= cur.val)
                second = cur;
            prev = cur;
            cur = cur.right;
        }
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}
