package practice.problem;

import practice.domain.TreeNode;

import java.util.*;

// 1110. Delete Nodes And Return Forest
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int d : to_delete)
            set.add(d);
        List<TreeNode> res = new ArrayList<>();
        if (!set.contains(root.val))
            res.add(root);
        helper(root, set, res);
        return res;
    }

    private TreeNode helper(TreeNode node, Set<Integer> set, List<TreeNode> res) {
        if (node == null)
            return null;
        node.left = helper(node.left, set, res);
        node.right = helper(node.right, set, res);
        if (set.contains(node.val)) {
            if (node.left != null)
                res.add(node.left);
            if (node.right != null)
                res.add(node.right);
            return null;
        }
        return node;
    }
}
