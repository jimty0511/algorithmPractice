package practice.problem;

import java.util.PriorityQueue;

// 407. Trapping Rain Water II
public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int n = heightMap.length, m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>((c1, c2) -> c1[2] - c2[2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j, heightMap[i][j]});
                }
            }
        }
        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, cell[2] - heightMap[x][y]);
                    queue.offer(new int[]{x, y, Math.max(cell[2], heightMap[x][y])});
                }
            }
        }
        return res;
    }

    int[] dirs = new int[]{0, 1, 0, -1, 0};

    public int trapRainWaterTwo(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0)
            return 0;
        int n = heightMap.length, m = heightMap[0].length;
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    visited[i][j] = true;
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                }
            }
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int k = 0; k < 4; k++) {
                int i = curr[0] + dirs[k];
                int j = curr[1] + dirs[k + 1];
                if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j])
                    continue;
                res += Math.max(0, curr[2] - heightMap[i][j]);
                pq.offer(new int[]{i, j, Math.max(curr[2], heightMap[i][j])});
                visited[i][j] = true;
            }
        }
        return res;
    }
}
