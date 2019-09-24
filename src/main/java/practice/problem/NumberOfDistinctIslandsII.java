package practice.problem;

import java.util.*;

// 711. Number of Distinct Islands II
public class NumberOfDistinctIslandsII {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] trans = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    List<int[]> cells = new ArrayList<>();
                    dfs(grid, i, j, cells);
                    String key = norm(cells);
                    set.add(key);
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> cells) {
        cells.add(new int[]{i, j});
        grid[i][j] = -1;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1)
                dfs(grid, x, y, cells);
        }
    }

    private String norm(List<int[]> cells) {
        List<String> forms = new ArrayList<>();
        for (int[] t : trans) {
            List<int[]> list1 = new ArrayList<>();
            List<int[]> list2 = new ArrayList<>();
            for (int[] cell : cells) {
                list1.add(new int[]{cell[0] * t[0], cell[1] * t[1]});
                list2.add(new int[]{cell[1] * t[1], cell[0] * t[0]});
            }
            forms.add(getKey(list1));
            forms.add(getKey(list2));
        }
        Collections.sort(forms);
        return forms.get(0);
    }

    private String getKey(List<int[]> cells) {
        Collections.sort(cells, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        StringBuilder sb = new StringBuilder();
        int x = cells.get(0)[0], y = cells.get(0)[1];
        for (int[] cell : cells)
            sb.append((cell[0] - x) + ":" + (cell[1] - y) + ":");
        return sb.toString();
    }
}
