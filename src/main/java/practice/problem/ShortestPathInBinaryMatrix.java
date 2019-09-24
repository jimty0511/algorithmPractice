package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 1091. Shortest Path in Binary Matrix
public class ShortestPathInBinaryMatrix {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1)
                    return ans + 1;
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] != 0)
                        continue;
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
