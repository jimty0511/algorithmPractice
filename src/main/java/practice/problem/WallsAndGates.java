package practice.problem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 286. Walls and Gates
public class WallsAndGates {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0)
            return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }

    int[] wallsAndGatesDir = {0, 1, 0, -1, 0};

    public void wallsAndGatesMultiEndBfs(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0)
            return;
        int n = rooms.length, m = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0)
                    queue.offer(i * m + j);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int i = x / m, j = x % m;
            for (int k = 0; k < 4; k++) {
                int p = i + wallsAndGatesDir[k], q = j + wallsAndGatesDir[k + 1];
                if (0 <= p && p < n && 0 <= q && q < m && rooms[p][q] == Integer.MAX_VALUE) {
                    rooms[p][q] = rooms[i][j] + 1;
                    queue.offer(p * m + q);
                }
            }
        }
    }

    public void wallsAndGatesLC(int[][] rooms) {
        // write your code here
        if (rooms == null || rooms.length == 0)
            return;
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != Integer.MAX_VALUE)
                    continue;
                rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                q.offer(new int[]{x, y});
            }
        }
    }

    public void wallsAndGatesLCTwo(int[][] rooms) {
        // write your code here
        if (rooms == null || rooms.length == 0)
            return;
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != Integer.MAX_VALUE)
                        continue;
                    rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}
