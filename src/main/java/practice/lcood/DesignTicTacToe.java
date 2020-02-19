package practice.lcood;

import java.util.Arrays;

// 746. Design Tic-Tac-Toe
public class DesignTicTacToe {

    int[] rows;
    int[] cols;
    int diagonal = 0;
    int antiDiagonal = 0;
    private char[][] board;
    private boolean curPlayerIsX;
    private boolean gameEnd;
    private int totalPlaced;

    /**
     * Initialize your data structure here.
     */
    public DesignTicTacToe() {
        rows = new int[3];
        cols = new int[3];
        board = new char[3][3];
        curPlayerIsX = true;
        gameEnd = false;
        totalPlaced = 0;
        initBoard();
    }

    private void initBoard() {
        for (char[] row : board) {
            Arrays.fill(row, '-');
        }
    }

    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        if (gameEnd)
            throw new GameEndException();
        if (board[row][col] != '-')
            throw new AlreadyTakenException();
        char curMove = curPlayerIsX ? 'X' : 'O';
        int toAdd = curPlayerIsX ? 1 : -1;
        curPlayerIsX = !curPlayerIsX;
        board[row][col] = curMove;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col)
            diagonal += toAdd;
        if (row + col == 2)
            antiDiagonal += toAdd;
        if (rows[row] == 3 || cols[col] == 3 || diagonal == 3 || antiDiagonal == 3) {
            System.out.println("x player wins!");
            gameEnd = true;
            return true;
        } else if (rows[row] == -3 || cols[col] == -3 || diagonal == -3 || antiDiagonal == -3) {
            System.out.println("o player wins!");
            gameEnd = true;
            return true;
        }
        totalPlaced++;
        if (totalPlaced == 9) {
            System.out.println("it's a draw");
            gameEnd = true;
        }
        return false;
    }

    class AlreadyTakenException extends Exception {
        public AlreadyTakenException() {
            super("Game has been ended, cannot make any more moves");
        }
    }

    class GameEndException extends Exception {
        public GameEndException() {
            super("This place has been taken");
        }
    }
}
