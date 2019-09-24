package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 987. Vertical Order Traversal of a Binary Tree
public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue> sub : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : sub.values()) {
                while (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int col, int level, TreeMap<Integer, TreeMap<Integer, PriorityQueue>> map) {
        if (root == null)
            return;
        if (!map.containsKey(col))
            map.put(col, new TreeMap<>());
        if (!map.get(col).containsKey(level))
            map.get(col).put(level, new PriorityQueue());
        map.get(col).get(level).offer(root.val);
        dfs(root.left, col - 1, level + 1, map);
        dfs(root.right, col + 1, level + 1, map);
    }
}
