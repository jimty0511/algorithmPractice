package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 100. Same Tree
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeStack(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode curP = stackP.pop();
            TreeNode curQ = stackQ.pop();
            if (curP.val != curQ.val)
                return false;
            if (curP.left != null && curQ.left != null) {
                stackP.push(curP.left);
                stackQ.push(curQ.left);
            } else if (curP.left == null && curQ.left == null) {

            } else {
                return false;
            }
            if (curP.right != null && curQ.left != null) {
                stackP.push(curP.right);
                stackQ.push(curQ.right);
            } else if (curP.right == null && curQ.right == null) {

            } else {
                return false;
            }
        }
        if (!stackP.isEmpty() || !stackQ.isEmpty())
            return false;
        return true;
    }
}
