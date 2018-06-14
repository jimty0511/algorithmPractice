package practice.problem;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

// 130. Surrounded Regions
public class SurroundedRegions {
    public void solveBfs(char[][] board) {
        if (board.length == 0)
            return;
        int rowN = board.length;
        int colN = board[0].length;
        Queue<Point> queue = new LinkedList<>();

        for (int r = 0; r < rowN; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = '+';
                queue.add(new Point(r, 0));
            }
            if (board[r][colN - 1] == 'O') {
                board[r][colN - 1] = '+';
                queue.add(new Point(r, colN - 1));
            }
        }
        for (int c = 0; c < colN; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = '+';
                queue.add(new Point(0, c));
            }
            if (board[rowN - 1][c] == 'O') {
                board[rowN - 1][c] = '+';
                queue.add(new Point(rowN - 1, c));
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int row = p.x;
            int col = p.y;
            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '+';
                queue.add(new Point(row - 1, col));
            }
            if (row + 1 < rowN && board[row + 1][col] == 'O') {
                board[row + 1][col] = '+';
                queue.add(new Point(row + 1, col));
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '+';
                queue.add(new Point(row, col - 1));
            }
            if (col + 1 < colN && board[row][col + 1] == 'O') {
                board[row][col + 1] = '+';
                queue.add(new Point(row, col + 1));
            }
        }

        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '+')
                    board[i][j] = 'O';
            }
        }
    }

    public void solveDfs(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int rowN = board.length, colN = board[0].length;
        for (int r = 0; r < rowN; r++) {
            if (board[r][0] == 'O')
                solveDfsHelper(board, r, 0);
            if (board[r][colN - 1] == 'O')
                solveDfsHelper(board, r, colN - 1);
        }
        for (int c = 0; c < colN; c++) {
            if (board[0][c] == 'O')
                solveDfsHelper(board, 0, c);
            if (board[rowN - 1][c] == 'O')
                solveDfsHelper(board, rowN - 1, c);
        }
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '+')
                    board[i][j] = 'O';
            }
        }
    }

    private void solveDfsHelper(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '+';
        if (i > 1 && board[i - 1][j] == 'O')
            solveDfsHelper(board, i - 1, j);
        if (i < board.length - 2 && board[i + 1][j] == 'O')
            solveDfsHelper(board, i + 1, j);
        if (j > 1 && board[i][j - 1] == 'O')
            solveDfsHelper(board, i, j - 1);
        if (j < board[0].length - 2 && board[i][j + 1] == 'O')
            solveDfsHelper(board, i, j + 1);
    }
}
