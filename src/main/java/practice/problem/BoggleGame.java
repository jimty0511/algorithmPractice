package practice.problem;

import java.util.ArrayList;
import java.util.List;

public class BoggleGame {
    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode('0');
        }

        public void insert(String word) {
            if (word == null || word.length() == 0)
                return;
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode(c);
                node = node.children[c - 'a'];
            }
            node.isWord = true;
            node.word = word;
        }
    }

    class TrieNode {
        char value;
        boolean isWord;
        TrieNode[] children;
        String word;

        TrieNode(char v) {
            value = v;
            isWord = false;
            children = new TrieNode[26];
            word = null;
        }
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int max = 0;

    public int boggleGame(char[][] board, String[] dict) {
        Trie trie = new Trie();
        for (String w : dict) {
            trie.insert(w);
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root, trie.root, new boolean[m][n], new ArrayList<>());
            }
        }
        return max;
    }

    private void dfs(char[][] board, int x, int y, TrieNode root, TrieNode cur, boolean[][] visited,
                     List<String> words) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || cur.children[board[x][y] - 'a'] == null)
            return;
        char c = board[x][y];
        cur = cur.children[c - 'a'];
        visited[x][y] = true;
        if (cur.isWord) {
            words.add(cur.word);
            max = Math.max(max, words.size());
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, root, root, visited, words);
                }
            }
        }
        for (int[] d : dirs) {
            dfs(board, x + d[0], y + d[1], root, cur, visited, words);
        }
        visited[x][y] = false;
    }

//    public int boggleGame(char[][] board, String[] words) {
//        Trie trie = new Trie();
//        for (String w : words)
//            trie.insert(w);
//        int m = board.length, n = board[0].length;
//        List<String> res = new ArrayList<>();
//        boolean[][] visited = new boolean[m][n];
//        List<String> path = new ArrayList<>();
//        findWords(res, board, visited, path, 0, 0, trie.root);
//        return res.size();
//    }
//
//    private void findWords(List<String> result, char[][] board, boolean[][] visited, List<String> words, int x, int y, TrieNode root) {
//        int m = board.length, n = board[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                List<List<Integer>> nextWordIndexes = new ArrayList<>();
//                List<Integer> path = new ArrayList<>();
//                getNextWords(nextWordIndexes, board, visited, path, i, j, root);
//                for (List<Integer> indexes : nextWordIndexes) {
//                    String word = "";
//                    for (int idx : indexes) {
//                        int row = idx / n, col = idx % n;
//                        visited[row][col] = true;
//                        word += board[row][col];
//                    }
//                    words.add(word);
//                    if (words.size() > result.size()) {
//                        result.clear();
//                        result.addAll(words);
//                    }
//                    findWords(result, board, visited, words, i, j, root);
//                    for (int idx : indexes) {
//                        int row = idx / n, col = idx % n;
//                        visited[row][col] = false;
//                    }
//                    words.remove(words.size() - 1);
//                }
//            }
//            y = 0;
//        }
//    }
//
//    private void getNextWords(List<List<Integer>> words, char[][] board,
//                              boolean[][] visited, List<Integer> path, int i, int j, TrieNode root) {
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] ||
//                root.children[board[i][j] - 'a'] == null)
//            return;
//        root = root.children[board[i][j] - 'a'];
//        if (root.isWord) {
//            List<Integer> newPath = new ArrayList<>(path);
//            newPath.add(i * board[0].length + j);
//            words.add(newPath);
//            return;
//        }
//        visited[i][j] = true;
//        path.add(i * board[0].length + j);
//        for (int[] d : dirs) {
//            getNextWords(words, board, visited, path, i + d[0], j + d[1], root);
//        }
//        path.remove(path.size() - 1);
//        visited[i][j] = false;
//    }
}
