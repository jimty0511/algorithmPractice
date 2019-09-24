package practice.lintcode;

import practice.domain.TreeNode;

// 245. Subtree
public class Subtree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null)
            return true;
        if (T1 == null)
            return false;
        if (isEqual(T1, T2))
            return true;
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2))
            return true;
        return false;
    }

    private boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return t1 == t2;
        if (t1.val != t2.val)
            return false;
        return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }
}
