package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 827. Making A Large Island
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int max = -1, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(grid, i, j, new boolean[m][n]));
                    grid[i][j] = 0;
                }
            }
        }
        return max == -1 ? m * n : max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
            return 0;
        visited[i][j] = true;
        int count = 1 + dfs(grid, i + 1, j, visited) + dfs(grid, i - 1, j, visited)
                + dfs(grid, i, j + 1, visited) + dfs(grid, i, j - 1, visited);
        return count;
    }

    public int largestIslandColor(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int n = grid.length;
        int color = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = paint(grid, i, j, color);
                    map.put(color, size);
                    color++;
                }
            }
        }
        int res = map.getOrDefault(2, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i > 0 ? grid[i - 1][j] : 0);
                    set.add(i < n - 1 ? grid[i + 1][j] : 0);
                    set.add(j > 0 ? grid[i][j - 1] : 0);
                    set.add(j < n - 1 ? grid[i][j + 1] : 0);
                    int newSize = 1;
                    for (int c : set) {
                        newSize += map.get(c);
                    }
                    res = Math.max(res, newSize);
                }
            }
        }
        return res;
    }

    private int paint(int[][] grid, int i, int j, int color) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1)
            return 0;
        grid[i][j] = color;
        return 1 + paint(grid, i + 1, j, color) + paint(grid, i - 1, j, color) + paint(grid, i, j + 1, color) + paint(grid, i, j - 1, color);
    }
}
