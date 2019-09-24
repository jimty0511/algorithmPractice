package practice.lintcode;

import java.util.HashSet;
import java.util.Set;

// 679. Unique Paths III
public class UniquePathsIIILC {
    public int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        Set[][] dp = new Set[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
                if (i == 0 && j == 0) {
                    dp[i][j].add(grid[0][0]);
                } else {
                    if (i != 0) {
                        for (Object v : dp[i - 1][j]) {
                            dp[i][j].add((int) v + grid[i][j]);
                        }
                    }
                    if (j != 0) {
                        for (Object v : dp[i][j - 1]) {
                            dp[i][j].add((int) v + grid[i][j]);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (Object v : dp[m - 1][n - 1])
            res += (int) v;
        return res;
    }
}
