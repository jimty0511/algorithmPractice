package practice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

// 630. Knight Shortest Path II
public class KnightShortestPathII {
    public static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        int m = grid.length, n = grid[0].length;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        int[][] dirs = new int[][]{{1, 2}, {-1, 2}, {2, 1}, {-2, 1}};
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point cur = q.poll();
                if (cur.x == m - 1 && cur.y == n - 1)
                    return step;
                for (int[] d : dirs) {
                    int xx = cur.x + d[0], yy = cur.y + d[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy] || grid[xx][yy])
                        continue;
                    visited[xx][yy] = true;
                    q.offer(new Point(xx, yy));
                }
            }
            step++;
        }
        return -1;
    }
}
