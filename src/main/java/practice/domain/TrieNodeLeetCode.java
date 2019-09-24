package practice.domain;

public class TrieNodeLeetCode {

    public char val;
    public boolean isWord;
    public TrieNodeLeetCode[] children = new TrieNodeLeetCode[26];

//    public TrieNodeLeetCode() {
//    }

    public TrieNodeLeetCode(char c) {
//        TrieNodeLeetCode node = new TrieNodeLeetCode();
        this.val = c;
    }
}
