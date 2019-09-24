package practice.problem;

// 794. Valid Tic-Tac-Toe State
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int turns = 0, diag = 0, antiDiag = 0;
        boolean xWin = false, oWin = false;
        int[] rows = new int[3], cols = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++;
                    rows[i]++;
                    cols[j]++;
                    if (i == j)
                        diag++;
                    if (i + j == 2)
                        antiDiag++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--;
                    rows[i]--;
                    cols[j]--;
                    if (i == j)
                        diag--;
                    if (i + j == 2)
                        antiDiag--;
                }
            }
        }
        xWin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                diag == 3 || antiDiag == 3;
        oWin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                diag == -3 || antiDiag == -3;
        if (xWin && turns == 0 || oWin && turns == 1)
            return false;
        return (turns == 0 || turns == 1) && (!xWin || !oWin);
    }
}
