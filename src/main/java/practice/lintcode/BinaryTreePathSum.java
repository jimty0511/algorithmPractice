package practice.lintcode;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 376. Binary Tree Path Sum
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), target, root);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int cur, TreeNode node) {
        if (node == null)
            return;
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == cur)
                res.add(new ArrayList<>(tmp));
            return;
        }
        if (node.left != null) {
            helper(res, tmp, cur - node.val, node.left);
            tmp.remove(tmp.size() - 1);
        }
        if (node.right != null) {
            helper(res, tmp, cur - node.val, node.right);
            tmp.remove(tmp.size() - 1);
        }
    }
}
