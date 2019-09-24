package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 934. Shortest Bridge
public class ShortestBridge {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < m; i++) {
            if (found)
                break;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, q, visited);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int i = cur[0] + d[0];
                    int j = cur[1] + d[1];
                    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
                        continue;
                    if (A[i][j] == 1)
                        return step;
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
            step++;
        }
        return step;
    }

    private void dfs(int[][] A, int i, int j, Queue<int[]> q, boolean[][] visited) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j] || A[i][j] == 0)
            return;
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for (int[] d : dirs)
            dfs(A, i + d[0], j + d[1], q, visited);
    }
}
