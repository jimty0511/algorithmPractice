package practice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

// 1752. Sliding On Ice Surface
public class SlidingOnIceSurface {
    /**
     * @param maze: The matrix array
     * @return: output the minimal step you need to take
     */
    public int getAns(String[] maze) {
        // Write your code here
        if (maze == null || maze.length == 0)
            return -1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length();
        int[] start = new int[2], end = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (maze[i].charAt(j) == 'T') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int xx = cur[0], yy = cur[1];
                    while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx].charAt(yy) != '*') {
                        if (maze[xx].charAt(yy) == 'T')
                            return level;
                        xx += d[0];
                        yy += d[1];
                    }
                    xx -= d[0];
                    yy -= d[1];
                    if (xx < 0 || yy < 0)
                        continue;
                    if (!visited[xx][yy]) {
                        visited[xx][yy] = true;
                        q.offer(new int[]{xx, yy});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
