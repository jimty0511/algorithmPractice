package practice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

// 1563. Shortest path to the destination
// Microsoft ladder
public class ShortestPathToTheDestination {
    /**
     * @param targetMap:
     * @return: nothing
     */
    public int shortestPath(int[][] targetMap) {
        // Write your code here
        if (targetMap == null || targetMap.length == 0 || targetMap[0].length == 0)
            return 0;
        int m = targetMap.length, n = targetMap[0].length, step = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[2]);
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (targetMap[cur[0]][cur[1]] == 2)
                    return step;
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || x >= targetMap.length || y < 0 || y >= targetMap[0].length || targetMap[x][y] == 1 || visited[x][y])
                        continue;
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
}
