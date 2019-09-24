package practice.lintcode;

import practice.domain.TreeNode;

// 900. Closest Binary Search Tree Value
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null)
            return 0;
        TreeNode upper = root, lower = root;
        while (root != null) {
            if (root.val > target) {
                upper = root;
                root = root.left;
            } else if (root.val < target) {
                lower = root;
                root = root.right;
            } else {
                return root.val;
            }
        }
        if (Math.abs(upper.val - target) > Math.abs(target - lower.val))
            return lower.val;
        return upper.val;
    }

    public int closestValueTwo(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
