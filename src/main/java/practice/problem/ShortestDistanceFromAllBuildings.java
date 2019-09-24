package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 317. Shortest Distance from All Buildings
public class ShortestDistanceFromAllBuildings {
    int[][] distance;
    int[][] reach;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        distance = new int[row][col];
        reach = new int[row][col];
        int buildingNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    helper(grid, i, j, row, col);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum)
                    shortest = Math.min(shortest, distance[i][j]);
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void helper(int[][] grid, int x, int y, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[m][n];
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dirs) {
                    int xx = curr[0] + d[0], yy = curr[1] + d[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || grid[xx][yy] != 0 || visited[xx][yy])
                        continue;
                    distance[xx][yy] += level;
                    reach[xx][yy]++;
                    visited[xx][yy] = true;
                    queue.offer(new int[]{xx, yy});
                }
            }
            level++;
        }
    }
}
