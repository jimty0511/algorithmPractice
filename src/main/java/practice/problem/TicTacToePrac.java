package practice.problem;

import java.util.Arrays;

public class TicTacToePrac {

    char[][] board;
    int size;

    // - - -
    // - - -
    // - - -
    public TicTacToePrac() {
        this.board = new char[3][3];
        for (char[] row : board) {
            Arrays.fill(row, '-');
        }
        this.size = 9;
    }

    public boolean add(char c, int row, int col) {
        if (isFull() || board[row][col] != '-')
            return false;
        board[row][col] = c;
        size--;
        return true;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char current : row) {
                sb.append(current).append('|');  // X|-|-|
            }
            sb.deleteCharAt(sb.length() - 1);  // X|-|-
            System.out.println(sb.toString());
            sb.setLength(0); // empty sb
        }
    }

    public boolean isFull() {
        return size == 0;
    }

    public boolean aiMove() throws Exception {
        if (isFull())
            throw new Exception("No valid move");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                    size--;
                    return true;
                }
            }
        }
        return false;
    }
}
