package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1192. Critical Connections in a Network
public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> c : connections) {
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }
        int timer = 0;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStamp = new int[n];
        helper(graph, -1, 0, 0, visited, res, timeStamp);
        return res;
    }

    private void helper(List<Integer>[] graph, int pre, int cur, int timer, boolean[] visited, List<List<Integer>> res, int[] timeStamp) {
        visited[cur] = true;
        int curTimeStamp = timer;
        timeStamp[cur] = timer++;
        for (int next : graph[cur]) {
            if (next == pre)
                continue;
            if (!visited[next])
                helper(graph, cur, next, timer, visited, res, timeStamp);
            timeStamp[cur] = Math.min(timeStamp[cur], timeStamp[next]);
            if (curTimeStamp < timeStamp[next])
                res.add(Arrays.asList(cur, next));
        }
    }
}
