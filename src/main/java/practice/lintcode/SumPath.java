package practice.lintcode;

import java.util.*;

// 1755. Sum Path
public class SumPath {

    private long res = 0;
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}};

    /**
     * @param rec: the map
     * @param k:   the goal
     * @return: the sum of paths
     */
    public long sumPath(int[][] rec, long k) {
        // Write your code here.
        int m = rec.length, n = rec[0].length;
        helper(rec, 0, 0, m, n, k);
        return res;
    }

    private void helper(int[][] rec, int i, int j, int m, int n, long k) {
        if (i < 0 || i >= m || j < 0 || j >= n || k < 0)
            return;
        if (i == m - 1 && j == n - 1) {
            k -= rec[i][j];
            if (k == 0)
                res++;
            return;
        }
        for (int[] d : dirs) {
            helper(rec, i + d[0], j + d[1], m, n, k - rec[i][j]);
        }
    }

    public long sumPathTwo(int[][] grid, long k) {
        int m = grid.length, n = grid[0].length, res = 0;
        Map<Long, Integer>[][] dp = new Map[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashMap<>();
                if (i == 0 && j == 0) {
                    dp[i][j].put((long) grid[i][j], 1);
                } else {
                    if (i != 0) {
                        if (dp[i - 1][j] != null) {
                            for (Long val : dp[i - 1][j].keySet()) {
//                                if (val + grid[i][j] > k)
//                                    continue;
                                dp[i][j].put(val + grid[i][j], dp[i][j].getOrDefault(val + grid[i][j], 0) + dp[i - 1][j].get(val));
                            }
                        }
                    }
                    if (j != 0) {
                        if (dp[i][j - 1] != null) {
                            for (Long val : dp[i][j - 1].keySet()) {
//                                if (val + grid[i][j] > k)
//                                    continue;
                                dp[i][j].put(val + grid[i][j], dp[i][j].getOrDefault(val + grid[i][j], 0) + dp[i][j - 1].get(val));
                            }
                        }
                    }
                }
            }
        }
        Map<Long, Integer> last = dp[m - 1][n - 1];
        if (last.containsKey(k))
            res = last.get(k);
        return res;
    }

    public long sumPathThree(int[][] grid, long k) {
        int m = grid.length, n = grid[0].length, res = 0;
        Map<Long, Integer>[][] dp = new Map[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = new HashMap<>();
                if (i == m - 1 && j == n - 1) {
                    dp[i][j].put(k - (long) grid[i][j], 1);
                } else {
                    if (i != m - 1) {
                        if (dp[i + 1][j] != null) {
                            for (Long val : dp[i + 1][j].keySet()) {
                                if (val - grid[i][j] < 0)
                                    continue;
                                dp[i][j].put(val - grid[i][j], dp[i][j].getOrDefault(val - grid[i][j], 0) + dp[i + 1][j].get(val));
                            }
                        }
                    }
                    if (j != n - 1) {
                        if (dp[i][j + 1] != null) {
                            for (Long val : dp[i][j + 1].keySet()) {
                                if (val - grid[i][j] < 0)
                                    continue;
                                dp[i][j].put(val - grid[i][j], dp[i][j].getOrDefault(val - grid[i][j], 0) + dp[i][j + 1].get(val));
                            }
                        }
                    }
                }
            }
        }
        Map<Long, Integer> first = dp[0][0];
        if (first.containsKey(0l))
            res = first.get(0l);
        return res;
    }

    public long sumPathFour(int[][] grid, long k) {
        int m = grid.length, n = grid[0].length, res = 0;
        Map<Long, Integer>[] dp = new Map[n];
        Arrays.fill(dp, new HashMap<>());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Map<Long, Integer> tmp = new HashMap<>();
                if (j == 0) {
                    if (i == 0)
                        tmp.put((long) grid[0][0], 1);
                    else {
                        for (Long val : dp[j].keySet()) {
//                            if (val + grid[i][j] > k)
//                                continue;
                            tmp.put(val + grid[i][j], dp[j].getOrDefault(val + grid[i][j], 0) + dp[j].get(val));
                        }
                    }
                } else {
                    for (Long val : dp[j - 1].keySet()) {
//                        if (val + grid[i][j] > k)
//                            continue;
                        tmp.put(val + grid[i][j], dp[j - 1].getOrDefault(val + grid[i][j], 0) + dp[j - 1].get(val));
                    }
                    for (Long val : dp[j].keySet()) {
//                        if (val + grid[i][j] > k)
//                            continue;
                        tmp.put(val + grid[i][j], dp[j].getOrDefault(val + grid[i][j], 0) + dp[j].get(val));
                    }
                }
                dp[j] = tmp;
            }
        }
        Map<Long, Integer> last = dp[n - 1];
        if (last.containsKey(k))
            res = last.get(k);
        return res;
    }

    public long sumPathFive(int[][] grid, long k) {
        int m = grid.length, n = grid[0].length, res = 0;
        long[][][] dp = new long[m][n + 1][(int) k + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                long[] next = new long[(int) k + 1];
                int val = grid[i][j - 1];
                for (int idx = 1; idx <= k + 1; idx++) {
                    if (i == 0) {
                        if (dp[i][j - 1][idx - 1] != 0 && idx + val <= k)
                            next[idx + val - 1] += dp[i][j - 1][idx - 1];
                    } else {
                        if (dp[i - 1][j][idx - 1] != 0 && idx - 1 + val <= k)
                            next[idx + val - 1] += dp[i - 1][j][idx - 1];
                        if (j > 1) {
                            if (dp[i][j - 1][idx - 1] != 0 && idx - 1 + val <= k)
                                next[idx + val - 1] += dp[i][j - 1][idx - 1];
                        }
                    }
                }
                dp[i][j] = next;
            }
        }
        return dp[m][n][(int) k];
    }
}
