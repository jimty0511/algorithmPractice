package practice.problem;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

// 490. The Maze
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        int m = maze.length, n = maze[0].length;
//        if (start[0] == destination[0] && start[1] == destination[1])
//            return true;
//        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//        boolean[][] visited = new boolean[m][n];
//        Queue<Point> queue = new LinkedList<>();
//        visited[start[0]][start[1]] = true;
//        queue.offer(new Point(start[0], start[1]));
//        while (!queue.isEmpty()) {
//            Point p = queue.poll();
//            int x = p.x, y = p.y;
//            for (int[] d : dir) {
//                int xx = x, yy = y;
//                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
//                    xx += d[0];
//                    yy += d[1];
//                }
//                xx -= d[0];
//                yy -= d[1];
//                if (visited[xx][yy])
//                    continue;
//                visited[xx][yy] = true;
//                if (xx == destination[0] && yy == destination[1])
//                    return true;
//                queue.offer(new Point(xx, yy));
//            }
//        }
//        return false;

        int m = maze.length, n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == destination[0] && y == destination[1])
                return true;
            for (int[] d : dir) {
                int xx = x, yy = y;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += d[0];
                    yy += d[1];
                }
                xx -= d[0];
                yy -= d[1];
                if (!visited[xx][yy]) {
                    q.offer(new int[]{xx, yy});
                    visited[xx][yy] = true;
                }
            }
        }
        return false;
    }
}
