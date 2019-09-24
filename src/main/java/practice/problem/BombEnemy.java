package practice.problem;

// 361. Bomb Enemy
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int max = 0;
        int row = 0;
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W')
                    continue;
                if (j == 0 || grid[i][j - 1] == 'W')
                    row = killedRow(grid, i, j);
                if (i == 0 || grid[i - 1][j] == 'W')
                    col[j] = killedCol(grid, i, j);
                if (grid[i][j] == '0')
                    max = Math.max(max, row + col[j]);
            }
        }
        return max;
    }

    private int killedRow(char[][] grid, int i, int j) {
        int num = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E')
                num++;
            j++;
        }
        return num;
    }

    private int killedCol(char[][] grid, int i, int j) {
        int num = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E')
                num++;
            i++;
        }
        return num;
    }
}
