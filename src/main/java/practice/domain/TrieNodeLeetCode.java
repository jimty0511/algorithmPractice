package practice.domain;

public class TrieNodeLeetCode {

    public char val;
    public boolean isWord;
    public TrieNodeLeetCode[] children = new TrieNodeLeetCode[26];

    public TrieNodeLeetCode() {
    }

    public TrieNodeLeetCode(char val) {
        TrieNodeLeetCode node = new TrieNodeLeetCode();
        node.val = val;
    }
}
