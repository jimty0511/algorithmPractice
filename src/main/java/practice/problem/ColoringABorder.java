package practice.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 1034. Coloring A Border
public class ColoringABorder {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int clr = grid[r0][c0], m = grid.length, n = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r0, c0});
        visited.add(r0 * n + c0);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == 0 || r == m - 1 || c == 0 || c == n - 1)
                grid[r][c] = color;
            for (int[] d : dirs) {
                int x = r + d[0], y = c + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x * n + y))
                    continue;
                if (grid[x][y] == clr) {
                    visited.add(x * n + y);
                    q.offer(new int[]{x, y});
                } else
                    grid[r][c] = color;
            }
        }
        return grid;
    }
}
