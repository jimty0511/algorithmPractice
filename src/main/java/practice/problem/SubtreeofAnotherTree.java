package practice.problem;

import practice.domain.TreeNode;

// 572. Subtree of Another Tree
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            return s.val == t.val && helper(s.left, t.left) && helper(s.right, t.right);
        } else {
            return s == null && t == null;
        }
    }

    public boolean isSubtreeTwo(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (helperTwo(s, t))
            return true;
        return isSubtreeTwo(s.left, t) || isSubtreeTwo(s.right, t);
    }

    private boolean helperTwo(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return helperTwo(s.left, t.left) && helperTwo(s.right, t.right);
    }
}
