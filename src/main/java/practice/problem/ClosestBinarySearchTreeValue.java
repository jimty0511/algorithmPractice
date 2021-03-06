package practice.problem;

import practice.domain.TreeNode;

// 270. Closest Binary Search Tree Value
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret))
                ret = root.val;
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }
}
