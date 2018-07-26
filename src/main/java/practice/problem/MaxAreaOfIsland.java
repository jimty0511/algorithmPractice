package practice.problem;

// 695. Max Area of Island
public class MaxAreaOfIsland {
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, helper(grid, i, j));
            }
        }
        return max;
    }

    private int helper(int[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0 || visited[row][col])
            return 0;
        visited[row][col] = true;
        return 1 + helper(grid, row + 1, col) + helper(grid, row - 1, col) + helper(grid, row, col + 1) + helper(grid, row, col - 1);
    }
}
