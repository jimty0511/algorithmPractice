package practice.problem;

// 37. Sudoku Solver
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solveTwo(board, 0, 0);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValidTwo(board, i, j, num)) {
                        board[i][j] = num;
                        if (solve(board))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c || board[row][i] == c)
                return false;
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c)
                return false;
        }
        return true;
    }

    private boolean solveTwo(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValidTwo(board, i, j, num)) {
                        board[i][j] = num;
                        if (solveTwo(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValidTwo(char[][] board, int row, int col, int num) {
        int blkRow = (row / 3) * 3, blkCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num || board[blkRow + i / 3][blkCol + i % 3] == num)
                return false;
        }
        return true;
    }
}
