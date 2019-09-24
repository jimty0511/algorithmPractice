package practice.problem;

import java.util.PriorityQueue;

// 499. The Maze III
public class TheMazeIII {

    class Point implements Comparable<Point> {

        int x, y, l;
        String s;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.l = Integer.MAX_VALUE;
            this.s = "";
        }

        public Point(int x, int y, int l, String s) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.s = s;
        }

        @Override
        public int compareTo(Point p) {
            return this.l == p.l ? this.s.compareTo(p.s) : this.l - p.l;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        Point[][] points = new Point[m][n];
        for (int i = 0; i < m * n; i++) {
            points[i / n][i % n] = new Point(i / n, i % n);
        }
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        String[] ds = new String[]{"u", "r", "d", "l"};
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(ball[0], ball[1], 0, ""));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (points[p.x][p.y].compareTo(p) <= 0)
                continue;
            points[p.x][p.y] = p;
            for (int i = 0; i < 4; i++) {
                int xx = p.x, yy = p.y, ll = p.l;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0 && (xx != hole[0] || yy != hole[1])) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                    ll++;
                }
                if (xx != hole[0] || yy != hole[1]) {
                    xx -= dir[i][0];
                    yy -= dir[i][1];
                    ll--;
                }
                pq.offer(new Point(xx, yy, ll, p.s + ds[i]));
            }
        }
        return points[hole[0]][hole[1]].l == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].s;
    }
}
