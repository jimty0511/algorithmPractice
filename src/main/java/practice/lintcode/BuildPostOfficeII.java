package practice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

// 573. Build Post Office II
public class BuildPostOfficeII {
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.min(ans, helper(grid, i, j));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int helper(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        int dist = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 2)
                        continue;
                    visited[x][y] = true;
                    if (grid[x][y] == 1)
                        sum += dist;
                    else if (grid[x][y] == 0) {
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c])
                    return Integer.MAX_VALUE;
            }
        }
        return sum;
    }
}
