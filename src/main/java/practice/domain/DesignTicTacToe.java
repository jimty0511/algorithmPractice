package practice.domain;

// 348. Design Tic-Tac-Toe
public class DesignTicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    /**
     * Initialize your data structure here.
     */
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        int size = rows.length;
        if (row == col)
            diagonal += toAdd;
        if (row + col == size - 1)
            antiDiagonal += toAdd;
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size)
            return player;
        return 0;
    }
}
