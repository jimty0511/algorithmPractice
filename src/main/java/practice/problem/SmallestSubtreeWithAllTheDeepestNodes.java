package practice.problem;

import javafx.util.Pair;
import practice.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 865. Smallest Subtree with all the Deepest Nodes
public class SmallestSubtreeWithAllTheDeepestNodes {
    Map<TreeNode, Integer> map = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        depth(root);
        return dfs(root);
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int max = Math.max(depth(root.left), depth(root.right)) + 1;
        map.put(root, max);
        return max;
    }

    private TreeNode dfs(TreeNode root) {
        int left = map.get(root.left) == null ? 0 : map.get(root.left);
        int right = map.get(root.right) == null ? 0 : map.get(root.right);
        if (left == right) {
            return root;
        }
        if (left > right)
            return dfs(root.left);
        return dfs(root.right);
    }

    public TreeNode subtreeWithAllDeepestTwo(TreeNode root) {
        return deep(root).getValue();
    }

    private Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null)
            return new Pair(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);
        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair<>(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
