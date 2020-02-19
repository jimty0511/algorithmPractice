package practice.lintcode;

import java.util.*;

// 816. Traveling Salesman
public class TravelingSalesman {

    class Pair implements Comparable<Pair> {
        int cur, remaining, cost, visited;

        Pair(int cur, int remaining, int cost, int visited) {
            this.cur = cur;
            this.remaining = remaining;
            this.cost = cost;
            this.visited = visited;
        }

        public int compareTo(Pair other) {
            return this.cost - other.cost;
        }
    }

    /**
     * @param n:     an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    public int minCost(int n, int[][] roads) {
        // Write your code here
        if (roads == null || roads.length == 0 || roads[0].length == 0)
            return 0;
//        Map<Integer, List<int[]>> map = new HashMap<>();
//        for (int[] r : roads) {
//            map.putIfAbsent(r[0], new ArrayList<>());
//            map.get(r[0]).add(new int[]{r[1], r[2]});
//            map.putIfAbsent(r[1], new ArrayList<>());
//            map.get(r[1]).add(new int[]{r[0], r[2]});
//        }
        int[][] cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], p = road[2];
            cost[v][u] = Math.min(cost[v][u], p);
            cost[u][v] = Math.min(cost[u][v], p);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{1, n - 1, 0, 1}); // {current, remain, cost, visited}
        int target = 0;
        for (int i = 0; i < n; i++)
            target |= 1 << i;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == 0 && cur[3] == target)
                return cur[2];
            for (int next = 1; next <= n; next++) {
                if (cost[cur[0]][next] != Integer.MAX_VALUE) {
                    if ((cur[3] & 1 << (next - 1)) == 1)
                        continue;
                    pq.offer(new int[]{next, cur[1] - 1, cur[2] + cost[cur[0]][next], cur[3] | 1 << (next - 1)});
                }
            }
        }
        return 0;
    }

    public int minCostTwo(int n, int[][] roads) {
        // Write your code here
        int[][] dp = new int[12][4096];
        int[][] mp = new int[12][12];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < roads.length; ++i) {
            int x = roads[i][0] - 1, y = roads[i][1] - 1;
            if (mp[x][y] == 0) mp[x][y] = mp[y][x] = roads[i][2];
            else mp[x][y] = mp[y][x] = Math.min(mp[x][y], roads[i][2]);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (1 << n); ++j) {
                dp[i][j] = 100000000;
            }
        }
        q.add(new int[]{0, 0, 1});
        dp[0][1] = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int w = tmp[0], x = tmp[1], y = tmp[2];
            if (w > dp[x][y]) continue;
            for (int i = 0; i < n; ++i)
                if (mp[x][i] != 0 && (y & (1 << i)) == 0) {
                    int ny = (y | (1 << i));
                    if (dp[i][ny] > dp[x][y] + mp[x][i]) {
                        dp[i][ny] = dp[x][y] + mp[x][i];
                        q.add(new int[]{dp[i][ny], i, ny});
                    }
                }
        }
        int min = 100000000;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, dp[i][(1 << n) - 1]);
        }
        return min;
    }
}
