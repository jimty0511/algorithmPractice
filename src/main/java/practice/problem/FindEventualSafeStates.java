package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 802. Find Eventual Safe States
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0)
            return res;
        int len = graph.length;
        int[] color = new int[len];
        for (int i = 0; i < len; i++) {
            if (helper(graph, i, color))
                res.add(i);
        }
        return res;
    }

    private boolean helper(int[][] graph, int start, int[] color) {
        if (color[start] != 0)
            return color[start] == 1;
        color[start] = 2;
        for (int next : graph[start]) {
            if (!helper(graph, next, color))
                return false;
        }
        color[start] = 1;
        return true;
    }
}
