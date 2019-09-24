package practice.problem;

import java.util.Arrays;

// 764. Largest Plus Sign
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int count = 1;
                    int dis = 1;
                    while (j - dis >= 0 && j + dis < N && i - dis >= 0 && i + dis < N
                            && grid[i - dis][j] == 1 && grid[i + dis][j] == 1
                            && grid[i][j - dis] == 1 && grid[i][j + dis] == 1) {
                        count++;
                        dis++;
                    }
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    public int orderOfLargestPlusSignTwo(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }
        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }
        for (int i = 0; i < N; i++) {
//            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
//                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
//                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
//                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
//                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
//            }
            for (int j = 0, l = 0; j < N; j++) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
            }
            for (int k = N - 1, r = 0; k >= 0; k--) {
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
            }
            for (int j = 0, u = 0; j < N; j++) {
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
            }
            for (int k = N - 1, d = 0; k >= 0; k--) {
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
}
