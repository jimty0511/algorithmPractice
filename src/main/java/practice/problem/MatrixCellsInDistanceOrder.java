package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 1030. Matrix Cells in Distance Order
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        int[][] res = new int[R * C][2];
        int i = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r0, c0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r < 0 || r >= R || c < 0 || c >= C || visited[r][c])
                continue;
            res[i++] = cur;
            visited[r][c] = true;
            q.offer(new int[]{r + 1, c});
            q.offer(new int[]{r - 1, c});
            q.offer(new int[]{r, c + 1});
            q.offer(new int[]{r, c - 1});
        }
        return res;
    }
}
