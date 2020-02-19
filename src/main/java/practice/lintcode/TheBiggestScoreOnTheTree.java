package practice.lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 953. The Biggest Score On The Tree
public class TheBiggestScoreOnTheTree {
    /**
     * @param x:      The vertex of edge
     * @param y:      The another vertex of edge
     * @param cost:   The cost of edge
     * @param profit: The profit of vertex
     * @return: Return the max score
     */
    public int getMaxScore(int[] x, int[] y, int[] cost, int[] profit) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            graph.putIfAbsent(x[i], new HashSet<>());
            graph.get(x[i]).add(y[i]);
        }
        helper(graph, 0, profit[0], cost, profit);
        return res;
    }

    private int res = Integer.MIN_VALUE;


    private void helper(Map<Integer, Set<Integer>> graph, int curKey, int curSum, int[] cost, int[] profit) {
        if (!graph.containsKey(curKey)) {
            res = Math.max(res, curSum);
            return;
        }
        Set<Integer> neighbours = graph.get(curKey);
        for (int next : neighbours) {
            curSum += profit[next] - cost[next - 1];
            helper(graph, next, curSum, cost, profit);
            curSum -= profit[next] - cost[next - 1];
        }
    }
}
