package practice.lintcode;

import practice.domain.TreeNode;

// 470. Tweaked Identical Binary Tree
public class TweakedIdenticalBinaryTree {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;
        if (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right))
            return true;
        if (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left))
            return true;
        return false;
    }
}
