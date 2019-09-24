package practice.problem;

import java.util.PriorityQueue;

// 778. Swim in Rising Water
public class SwimInRisingWater {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        int level = 0;
        boolean[][] visited = new boolean[n][n];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];
            level = Math.max(level, curr[2]);
            if (i == n - 1 && j == n - 1)
                break;
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= n || visited[newI][newJ])
                    continue;
                visited[newI][newJ] = true;
                pq.offer(new int[]{newI, newJ, grid[newI][newJ]});
            }
        }
        return level;
    }

    public int swimInWaterUf(int[][] grid) {
        int n = grid.length;
        UF uf = new UF(n * n);
        int time = 0;
        while (!uf.isConnected(0, n * n - 1)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > time)
                        continue;
                    if (i < n - 1 && grid[i + 1][j] <= time)
                        uf.union(i * n + j, i * n + j + n);
                    if (j < n - 1 && grid[i][j + 1] <= time)
                        uf.union(i * n + j, i * n + j + 1);
                }
            }
            time++;
        }
        return time - 1;
    }

    class UF {
        int[] parents;

        public UF(int N) {
            parents = new int[N];
            for (int i = 0; i < N; i++)
                parents[i] = i;
        }

        public int find(int val) {
            while (val != parents[val]) {
                parents[val] = parents[parents[val]];
                val = parents[val];
            }
            return val;
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        public void union(int i, int j) {
            if (isConnected(i, j))
                return;
            parents[find(i)] = find(j);
        }
    }
}
