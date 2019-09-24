package practice.problem;

import java.util.*;

// 323. Number of Connected Components in an Undirected Graph
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1)
            return n;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    visited[curr] = true;
                    for (int next : map.get(curr)) {
                        if (!visited[next])
                            queue.offer(next);
                    }
                }
            }
        }
        return count;
    }

    public int countComponentsUf(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++)
            roots[i] = i;
        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if (root1 != root2) {
                roots[root1] = root2;
                n--;
            }
        }
        return n;
    }

    private int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
