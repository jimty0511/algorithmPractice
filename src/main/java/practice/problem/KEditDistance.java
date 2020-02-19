package practice.problem;

import java.util.ArrayList;
import java.util.List;

public class KEditDistance {
    public List<String> kDistance(String[] words, String target, int k) {
        List<String> res = new ArrayList<>();
        for (String s : words) {
            if (minDistance(s, target, k))
                res.add(s);
        }
        return res;
    }

    public boolean minDistance(String word1, String word2, int k) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n] < k;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
            cur.isWord = true;
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = null;
        }
    }

    public List<String> kDistanceTwo(String[] words, String target, int k) {
        Trie trie = new Trie();
        for (String w : words)
            trie.insert(w);
        List<String> res = new ArrayList<>();
        int n = target.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = i;
        helper(trie.root, res, k, target, dp);
        return res;
    }

    private void helper(TrieNode node, List<String> res, int k, String target, int[] dp) {
        int n = target.length();
        if (node.isWord && dp[n] <= k)
            res.add(node.word);
        int[] next = new int[n + 1];
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                next[0] = dp[0] + 1;
                for (int j = 1; j <= n; j++) {
                    if (target.charAt(j - 1) - 'a' == i)
                        next[j] = Math.min(dp[j - 1], Math.min(next[j - 1] + 1, dp[j] + 1));
                    else
                        next[j] = Math.min(dp[j - 1] + 1, Math.min(next[j - 1] + 1, dp[j] + 1));
                }
                helper(node.children[i], res, k, target, next);
            }
        }
    }
}
