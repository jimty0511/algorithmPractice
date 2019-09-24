package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 211. Add and Search Word - Data structure design
public class AddAndSearchWord {

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWord() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length)
            return !node.item.equals("");
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i]))
                        return true;
                }
            }
        }
        return false;
    }


    /**
     * Map way
     */

    class MapTrieNode {
        Map<Character, MapTrieNode> children;
        boolean isWord;

        public MapTrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    MapTrieNode mapRoot = new MapTrieNode();

    /**
     * Adds a word into the data structure.
     */
    public void addWordTwo(String word) {
        MapTrieNode curr = mapRoot;
        for (char c : word.toCharArray()) {
            MapTrieNode next = curr.children.get(c);
            if (next == null) {
                next = new MapTrieNode();
                curr.children.put(c, next);
            }
            curr = next;
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean searchTwo(String word) {
        return matchTwo(word.toCharArray(), 0, mapRoot);
    }

    private boolean matchTwo(char[] chs, int k, MapTrieNode node) {
        if (k == chs.length)
            return node.isWord;
        if (chs[k] != '.') {
            return node.children.get(chs[k]) != null && matchTwo(chs, k + 1, node.children.get(chs[k]));
        } else {
            for (int i = 0; i < node.children.size(); i++) {
                for (Map.Entry<Character, MapTrieNode> entry : node.children.entrySet()) {
                    if (matchTwo(chs, k + 1, entry.getValue()))
                        return true;
                }
            }
        }
        return false;
    }
}
