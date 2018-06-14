package practice.problem;

import java.util.*;

// 743. Network Delay Time
public class NetworkDelyTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0)
            return -1;
        Map<Integer, Map<Integer, Integer>> path = new HashMap<>();
        for (int[] time : times) {
            Map<Integer, Integer> sourceMap = path.get(time[0]);
            if (sourceMap == null) {
                sourceMap = new HashMap<>();
                path.put(time[0], sourceMap);
            }
            Integer dis = sourceMap.get(time[1]);
            if (dis == null || dis > time[2]) {
                sourceMap.put(time[1], time[2]);
            }
        }
        Map<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(K, 0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        pq.offer(new int[]{K, 0});
        int max = -1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int distance = cur[1];
            if (distanceMap.containsKey(node) && distanceMap.get(node) < distance) {
                continue;
            }
            Map<Integer, Integer> sourceMap = path.get(node);
            if (sourceMap == null)
                continue;
            for (Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {
                int absoluteDistance = distance + entry.getValue();
                int targetNode = entry.getKey();
                if (distanceMap.containsKey(targetNode) && distanceMap.get(targetNode) <= absoluteDistance) {
                    continue;
                }
                distanceMap.put(targetNode, absoluteDistance);
                pq.offer(new int[]{targetNode, absoluteDistance});
            }
        }
        for (int val : distanceMap.values()) {
            max = Math.max(val, max);
        }
        return distanceMap.size() == N ? max : -1;
    }

    public int networkDelayTimeBfs(int[][] times, int N, int K) {
        if (times == null || times.length == 0)
            return -1;
        int r = times.length, max = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < r; i++) {
            int[] nums = times[i];
            int u = nums[0], v = nums[1];
            List<Integer> list = map.getOrDefault(u, new ArrayList<>());
            list.add(i);
            map.put(u, list);
        }
        if (map.get(K) == null)
            return -1;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, max);
        dist[K] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(K);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int t = dist[u];
            List<Integer> list = map.get(u);
            if (list == null)
                continue;
            for (int n : list) {
                int v = times[n][1];
                int time = times[n][2];
                if (dist[v] > t + time) {
                    dist[v] = t + time;
                    queue.add(v);
                }
            }
        }
        int res = -1;
        for (int i = 1; i <= N; i++) {
            int d = dist[i];
            if (d == max)
                return -1;
            res = d > res ? d : res;
        }
        return res;

    }
}
