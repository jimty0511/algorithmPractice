package practice.lintcode;

import java.util.*;

// 783. Minimum Risk Path
public class MinimumRiskPath {
    public int getMinRiskValue(int n, int m, int[] x, int[] y, int[] w) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            graph.putIfAbsent(x[i], new HashMap<>());
            graph.putIfAbsent(y[i], new HashMap<>());
            graph.get(x[i]).put(y[i], w[i]);
            graph.get(y[i]).put(x[i], w[i]);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (graph.containsKey(cur)) {
                for (Map.Entry<Integer, Integer> entry : graph.get(cur).entrySet()) {
                    int next = entry.getKey();
                    int weight = entry.getValue();
                    int newWeight = 0;
                    if (cur == 0) {
                        newWeight = weight;
                    } else {
                        newWeight = Math.max(weight, dp[cur]);
                    }
                    if (newWeight < dp[next]) {
                        dp[next] = newWeight;
                        if (next != n)
                            q.offer(next);
                    }
                }
            }
        }
        return dp[n];
    }

    public int getMinRiskValueDfs(int n, int m, int[] x, int[] y, int[] w) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            graph.putIfAbsent(x[i], new HashMap<>());
            graph.putIfAbsent(y[i], new HashMap<>());
            graph.get(x[i]).put(y[i], w[i]);
            graph.get(y[i]).put(x[i], w[i]);
        }
        boolean[] visited = new boolean[n + 1];
        return helper(graph, 0, n, 0, Integer.MAX_VALUE, visited);
    }

    private int helper(Map<Integer, Map<Integer, Integer>> graph, int cur, int target, int weight, int res, boolean[] visited) {
        if (cur == target)
            return weight;
        if (weight >= res)
            return Integer.MAX_VALUE;
        visited[cur] = true;
        for (Map.Entry<Integer, Integer> entry : graph.get(cur).entrySet()) {
            int next = entry.getKey();
            if (visited[next])
                continue;
            res = Math.min(res, helper(graph, next, target, Math.max(weight, entry.getValue()), res, visited));
        }
        visited[cur] = false;
        return res;
    }
}
