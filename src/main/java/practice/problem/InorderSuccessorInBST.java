package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 285. Inorder Successor in BST
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else
                root = root.right;
        }
        return succ;
    }

    public TreeNode inorderSuccessorTwo(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (succ != null && succ.val == p.val)
                return root;
            succ = root;
            root = root.right;
        }
        return null;
    }
}
