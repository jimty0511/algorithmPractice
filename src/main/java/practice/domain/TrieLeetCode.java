package practice.domain;

// 208. Implement Trie (Prefix Tree)
public class TrieLeetCode {

    private TrieNodeLeetCode root;

    /**
     * Initialize your data structure here.
     */
    public TrieLeetCode() {
        root = new TrieNodeLeetCode(' ');
//        root.val = ' ';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNodeLeetCode ws = root;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (ws.children[c - 'a'] == null) {
//                ws.children[c - 'a'] = new TrieNodeLeetCode(c);
//            }
//            ws = ws.children[c - 'a'];
//        }
        for (char c : word.toCharArray()) {
            if (ws.children[c - 'a'] == null)
                ws.children[c - 'a'] = new TrieNodeLeetCode(c);
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNodeLeetCode ws = root;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (ws.children[c - 'a'] == null)
//                return false;
//            ws = ws.children[c - 'a'];
//        }
        for (char c : word.toCharArray()) {
            if (ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNodeLeetCode ws = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            char c = prefix.charAt(i);
//            if (ws.children[c - 'a'] == null)
//                return false;
//            ws = ws.children[c - 'a'];
//        }
        for (char c : prefix.toCharArray()) {
            if (ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
