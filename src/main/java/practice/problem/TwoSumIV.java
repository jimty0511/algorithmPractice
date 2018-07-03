package practice.problem;

import practice.domain.TreeNode;

import java.util.HashSet;
import java.util.Set;

// 653. Two Sum IV - Input is a BST
public class TwoSumIV {
    Set<Integer> integerSet = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (integerSet.contains(k - root.val)) return true;
        integerSet.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
