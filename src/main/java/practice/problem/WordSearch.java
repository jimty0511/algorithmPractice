package practice.problem;

// 79. Word Search
// Microsoft ladder
public class WordSearch {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || board.length * board[0].length < word.length())
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int idx) {
        if (idx == word.length())
            return true;
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && word.charAt(idx) == board[i][j]) {
            visited[i][j] = true;
            for (int[] d : dir) {
                if (helper(board, word, visited, i + d[0], j + d[1], idx + 1))
                    return true;
            }
            visited[i][j] = false;
        }
        return false;
    }

    public boolean existTwo(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (existHelper(board, i, j, wordChars, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, int i, int j, char[] word, int index) {
        if (index == word.length)
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[i].length)
            return false;
        if (board[i][j] != word[index])
            return false;
        board[i][j] ^= 256;
        boolean exist = existHelper(board, i, j + 1, word, index + 1) ||
                existHelper(board, i, j - 1, word, index + 1) ||
                existHelper(board, i + 1, j, word, index + 1) ||
                existHelper(board, i - 1, j, word, index + 1);
        board[i][j] ^= 256;
        return exist;
    }
}
