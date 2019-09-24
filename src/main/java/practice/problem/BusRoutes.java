package practice.problem;

import java.util.*;

// 815. Bus Routes
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        if (S == T)
            return 0;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new HashSet<>());
                graph.get(routes[i][j]).add(i);
            }
        }
        q.offer(S);
        while (!q.isEmpty()) {
            int len = q.size();
            res++;
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                Set<Integer> buses = graph.get(cur);
                for (int bus : buses) {
                    if (visited.contains(bus))
                        continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T)
                            return res;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }

    public int numBusesToDestinationTwo(int[][] routes, int S, int T) {
        if (S == T)
            return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.putIfAbsent(routes[i][j], new HashSet<>());
                map.get(routes[i][j]).add(i);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == T)
                    return res;
                for (int bus : map.get(cur)) {
                    if (visited.contains(bus))
                        continue;
                    visited.add(bus);
                    for (int next : routes[bus])
                        q.offer(next);
                }
            }
            res++;
        }
        return -1;
    }
}
