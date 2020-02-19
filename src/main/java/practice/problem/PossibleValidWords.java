package practice.problem;

import java.util.ArrayList;
import java.util.List;

public class PossibleValidWords {

    class TrieNode {
        TrieNode[] children;
        boolean isLeaf;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isLeaf = false;
            this.word = null;
        }
    }

    public List<String> solution(char[] letters, String[] dict) {
        TrieNode root = new TrieNode();
        for (String d : dict)
            insertWord(root, d);
        List<String> res = new ArrayList<>();
//        int[] hash = new int[26];
        boolean[] hash = new boolean[26];
        for (char l : letters) {
//            hash[l - 'a']++;
            hash[l - 'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
//            if (hash[i] > 0 && root.children[i] != null)
            if (hash[i] && root.children[i] != null)
                helper(res, hash, root.children[i]);
        }
        return res;
    }

    private void insertWord(TrieNode root, String w) {
        TrieNode cur = root;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null)
                cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }
        cur.isLeaf = true;
        cur.word = w;
    }

    private void helper(List<String> res, boolean[] hash, TrieNode node) {
        if (node.isLeaf) {
            res.add(node.word);
        }
        for (int i = 0; i < 26; i++) {
//            if (hash[i] > 0 && node.children[i] != null) {
//                hash[i]--;
//                helper(res, hash, node.children[i]);
//                hash[i]++;
//            }
            if (hash[i] && node.children[i] != null) {
                helper(res, hash, node.children[i]);
            }
        }
    }
}
