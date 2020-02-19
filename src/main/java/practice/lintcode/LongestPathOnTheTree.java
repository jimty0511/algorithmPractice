package practice.lintcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 1469. Longest Path On The Tree
public class LongestPathOnTheTree {

    class TreeNode {
        int val;
        Map<TreeNode, Integer> neighbors;

        public TreeNode(int val) {
            this.val = val;
            neighbors = new HashMap<>();
        }
    }

    class Pair implements Comparable<Pair> {

        TreeNode node;
        int dis;

        public Pair(TreeNode node, int dis) {
            this.node = node;
            this.dis = dis;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dis - o.dis;
        }
    }

    /**
     * @param n:      The number of nodes
     * @param starts: One point of the edge
     * @param ends:   Another point of the edge
     * @param lens:   The length of the edge
     * @return: Return the length of longest path on the tree.
     */
    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        // Write your code here
        if (n <= 1)
            return 0;
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < starts.length; i++) {
            map.putIfAbsent(starts[i], new TreeNode(starts[i]));
            map.putIfAbsent(ends[i], new TreeNode(ends[i]));
            TreeNode node1 = map.get(starts[i]);
            TreeNode node2 = map.get(ends[i]);
            node1.neighbors.put(node2, lens[i]);
            node2.neighbors.put(node1, lens[i]);
        }
        TreeNode root = map.get(0);
        Pair p = bfs(n, root);
        return bfs(n, p.node).dis;
    }

    private Pair bfs(int n, TreeNode node) {
        Pair res = new Pair(null, -1);
        boolean[] visited = new boolean[n];
        visited[node.val] = true;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(node, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            res = cur;
            for (Map.Entry<TreeNode, Integer> e : cur.node.neighbors.entrySet()) {
                if (visited[e.getKey().val])
                    continue;
                visited[e.getKey().val] = true;
                pq.offer(new Pair(e.getKey(), cur.dis + e.getValue()));
            }
        }
        return res;
    }
}
