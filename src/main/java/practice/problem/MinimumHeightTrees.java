package practice.problem;

import java.util.*;

// 310. Minimum Height Trees
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1)
                leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1)
                    newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public List<Integer> findMinHeightTreesQueue(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>(n);
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0)
                return res;
            else if (degree[i] == 1)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int curr = queue.poll();
                res.add(curr);
                degree[curr]--;
                for (int k = 0; k < adj.get(curr).size(); k++) {
                    int next = adj.get(curr).get(k);
                    if (degree[next] == 0)
                        continue;
                    if (degree[next] == 2)
                        queue.offer(next);
                    degree[next]--;
                }
            }
        }
        return res;
    }
}
