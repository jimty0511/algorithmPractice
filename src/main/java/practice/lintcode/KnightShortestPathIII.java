package practice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

// 1768. Knight Shortest Path III
public class KnightShortestPathIII {

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
     * @param grid:        the array grid
     * @param source:      a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int m = grid.length, n = grid[0].length;
        Queue<Point> q = new LinkedList<>();
        q.offer(source);
        int[][] dirs = new int[][]{{2, 2}, {2, -2}, {-2, 2}, {-2, -2}};
        int[][] barrier = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        boolean[][] visited = new boolean[m][n];
        visited[source.x][source.y] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point cur = q.poll();
                if (cur.x == destination.x && cur.y == destination.y)
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
