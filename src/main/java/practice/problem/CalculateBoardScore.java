package practice.problem;

// https://leetcode.com/discuss/interview-question/341292/Airbnb-or-Phone-Screen-or-Calculate-Board-Score
public class CalculateBoardScore {
    public int calculateScore(String[] strs) {
        if (strs == null || strs.length == 0)
            return 0;
        int res = 0, m = strs.length;
        String[][] board = new String[m][m];
        for (int i = 0; i < m; i++) {
            String[] arr = strs[i].split(" ");
            board[i] = arr;
        }
        boolean[][] visited = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int[] tmp = new int[2];
                helper(board, board[i][j].charAt(0), i, j, visited, tmp);
                res += tmp[0] * tmp[1];
            }
        }
        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void helper(String[][] board, char c, int i, int j, boolean[][] visited, int[] sum) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j].charAt(0) != c)
            return;
        sum[0]++;
        int num = board[i][j].charAt(1) - '0';
        sum[1] += num;
        visited[i][j] = true;
        for (int[] d : dirs) {
            helper(board, c, i + d[0], j + d[1], visited, sum);
        }
    }
}
