package practice.domain;

import java.util.HashMap;
import java.util.Map;

// 745. Prefix and Suffix Search
public class WordFilter {

    class TrieNode {
        String word;
        TrieNode[] children;

        TrieNode() {
            word = null;
            children = new TrieNode[26];
        }
    }

    Map<String, Integer> map;
    TrieNode root;
    int ans = -1;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
            addWord(words[i], root);
        }
    }

    private void addWord(String word, TrieNode node) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';
            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
        }
        node.word = word;
    }

    public int f(String prefix, String suffix) {
        TrieNode node = findPre(root, prefix);
        if (node == null)
            return -1;
        ans = -1;
        findSuffix(node, suffix, suffix.length());
        return ans;
    }

    private TrieNode findPre(TrieNode node, String prefix) {
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (node.children[c] == null)
                return null;
            node = node.children[c];
        }
        return node;
    }

    private void findSuffix(TrieNode node, String suffix, int len) {
        if (node.word != null) {
            int start = node.word.length() - len;
            if (start >= 0 && node.word.substring(start).equals(suffix)) {
                if (map.get(node.word) > ans)
                    ans = map.get(node.word);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null)
                findSuffix(node.children[i], suffix, len);
        }
    }
}
