package practice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

// 1479. Can Reach The Endpoint
public class CanReachTheEndpoint {
    /**
     * @param map: the map
     * @return: can you reach the endpoint
     */
    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        if (map == null || map.length == 0 || map[0].length == 0)
            return false;
        int m = map.length, n = map[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[2]);
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || map[x][y] == 0)
                    continue;
                if (map[x][y] == 9)
                    return true;
                visited[x][y] = true;
                q.offer(new int[]{x, y});
            }
        }
        return false;
    }
}
