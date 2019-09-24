package practice.problem;

import practice.domain.TreeNode;

import java.util.*;

// 742. Closest Leaf in a Binary Tree (854 LC)
public class ClosestLeafInABinaryTree {

    public int findClosestLeaf(TreeNode root, int k) {
        // Write your code here
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        TreeNode kNode = dfs(root, k, map);
        q.offer(kNode);
        visited.add(kNode);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left == null && curr.right == null)
                return curr.val;
            if (curr.left != null && visited.add(curr.left))
                q.offer(curr.left);
            if (curr.right != null && visited.add(curr.right))
                q.offer(curr.right);
            if (map.containsKey(curr) && visited.add(map.get(curr)))
                q.offer(map.get(curr));
        }
        return -1;
    }

    private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root.val == k)
            return root;
        if (root.left != null) {
            map.put(root.left, root);
            TreeNode left = dfs(root.left, k, map);
            if (left != null)
                return left;
        }
        if (root.right != null) {
            map.put(root.right, root);
            TreeNode right = dfs(root.right, k, map);
            if (right != null)
                return right;
        }
        return null;
    }
}
