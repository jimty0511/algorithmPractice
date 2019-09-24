package practice.problem;

import java.util.*;

public class MinimumVerticestoTraverseDirectedGraph {
    public List<Integer> getMin(int[][] edges, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new HashSet<>());
        for (int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                res.add(i);
                visited.add(i);
                helper(res, graph, i, i, visited, new HashSet<>());
            }
        }
        return new ArrayList<>(res);
    }

    private void helper(Set<Integer> res, Map<Integer, Set<Integer>> graph, int cur, int start,
                        Set<Integer> visited, Set<Integer> curVisited) {
        curVisited.add(cur);
        visited.add(cur);
        for (int next : graph.get(cur)) {
            if (res.contains(next) && next != start)
                res.remove(next);
            if (!curVisited.contains(next))
                helper(res, graph, next, start, visited, curVisited);
        }
    }

}
