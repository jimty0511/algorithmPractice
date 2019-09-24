package practice.problem;

// 999. Available Captures for Rook
public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int x0 = 0, y0 = 0, res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x0 = i;
                    y0 = j;
                    break;
                }
            }
        }
        for (int[] d : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
            for (int x = x0 + d[0], y = y0 + d[1]; x >= 0 && x < 8 && y >= 0 && y < 8; x += d[0], y += d[1]) {
                if (board[x][y] == 'p')
                    res++;
                if (board[x][y] != '.')
                    break;
            }
        }
        return res;
    }
}
