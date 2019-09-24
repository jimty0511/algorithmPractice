package practice.problem;

import java.util.PriorityQueue;

// 505. The Maze II
public class TheMazeII {

    class Point {
        int x, y, l;

        public Point(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] length = new int[m][n];
        for (int i = 0; i < m * n; i++)
            length[i / n][i % n] = Integer.MAX_VALUE;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.l - b.l);
        pq.offer(new Point(start[0], start[1], 0));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (length[p.x][p.y] <= p.l)
                continue;
            length[p.x][p.y] = p.l;
            for (int[] d : dir) {
                int xx = p.x, yy = p.y, ll = p.l;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += d[0];
                    yy += d[1];
                    ll++;
                }
                xx -= d[0];
                yy -= d[1];
                ll--;
                pq.offer(new Point(xx, yy, ll));
            }
        }
        return length[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : length[destination[0]][destination[1]];
    }
}
