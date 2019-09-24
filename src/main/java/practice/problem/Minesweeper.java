package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 529. Minesweeper
public class Minesweeper {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public char[][] updateBoardDfs(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for (int[] dir : dirs) {
                int r = row + dir[0], c = col + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n)
                    continue;
                if (board[r][c] == 'M' || board[r][c] == 'X')
                    count++;
            }
            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                board[row][col] = 'B';
                for (int[] dir : dirs) {
                    int r = row + dir[0], c = col + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n)
                        continue;
                    if (board[r][c] == 'E')
                        updateBoardDfs(board, new int[]{r, c});
                }
            }
        }
        return board;
    }

    public char[][] updateBoardBfs(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
            } else {
                int count = 0;
                for (int[] dir : dirs) {
                    int r = row + dir[0], c = col + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n)
                        continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X')
                        count++;
                }
                if (count > 0) {
                    board[row][col] = (char) (count + '0');
                } else {
                    board[row][col] = 'B';
                    for (int[] dir : dirs) {
                        int r = row + dir[0], c = col + dir[1];
                        if (r < 0 || r >= m || c < 0 || c >= n)
                            continue;
                        if (board[r][c] == 'E') {
                            queue.offer(new int[]{r, c});
                            board[r][c] = 'B';
                        }
                    }
                }
            }
        }
        return board;
    }
}
