package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 1162. As Far from Land as Possible
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int level = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            level++;
        }
        return level <= 0 ? -1 : level;
    }
}
