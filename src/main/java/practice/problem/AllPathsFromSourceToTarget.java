package practice.problem;

import java.util.*;

// 797. All Paths From Source to Target
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        return dfs(graph, 0, map);
    }

    private List<List<Integer>> dfs(int[][] graph, int node, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(node))
            return map.get(node);
        List<List<Integer>> res = new ArrayList<>();
        if (node == graph.length - 1) {
            List<Integer> path = new LinkedList<>();
            path.add(node);
            res.add(path);
        } else {
            for (int next : graph[node]) {
                List<List<Integer>> lists = dfs(graph, next, map);
                for (List<Integer> path : lists) {
                    LinkedList<Integer> newPath = new LinkedList<>(path);
                    newPath.addFirst(node);
                    res.add(newPath);
                }
            }
        }
        map.put(node, res);
        return res;
    }
}
