package practice.problem;

import java.util.*;

// 212. Word Search II
public class WordSearchII {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, root, result);
            }
        }
        return result;
    }

    private void helper(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        if (i > 0)
            helper(board, i - 1, j, p, res);
        if (j > 0)
            helper(board, i, j - 1, p, res);
        if (i < board.length - 1)
            helper(board, i + 1, j, p, res);
        if (j < board[0].length - 1)
            helper(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWordsTwo(char[][] board, List<String> words) {
        if (board == null || board.length == 0)
            return null;
        boolean[][] visited = new boolean[board.length][board[0].length];
        Map<String, Boolean> prefix = buildPrefix(words);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                dfs(board, visited, i, j, String.valueOf(board[i][j]), prefix, set);
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(set);
    }

    private Map<String, Boolean> buildPrefix(List<String> words) {
        Map<String, Boolean> prefix = new HashMap<>();
        for (String w : words) {
            for (int i = 0; i < w.length() - 1; i++) {
                String pre = w.substring(0, i + 1);
                prefix.putIfAbsent(pre, false);
            }
            prefix.put(w, true);
        }
        return prefix;
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y, String word, Map<String, Boolean> prefix, Set<String> set) {
        if (!prefix.containsKey(word))
            return;
        if (prefix.get(word))
            set.add(word);
        for (int[] d : dirs) {
            int xx = x + d[0], yy = y + d[1];
            if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length || visited[xx][yy])
                continue;
            visited[xx][yy] = true;
            dfs(board, visited, xx, yy, word + board[xx][yy], prefix, set);
            visited[xx][yy] = false;
        }
    }
}
