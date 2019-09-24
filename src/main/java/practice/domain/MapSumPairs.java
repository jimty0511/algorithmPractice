package practice.domain;

import java.util.HashMap;
import java.util.Map;

// 677. Map Sum Pairs
public class MapSumPairs {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        int value;

        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
            value = 0;
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
//    public MapSumPairs() {
//        root = new TrieNode();
//    }
    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isWord = true;
        cur.value = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null)
                return 0;
            cur = next;
        }
        return dfs(cur);
    }

    private int dfs(TrieNode node) {
        int sum = 0;
        for (char c : node.children.keySet()) {
            sum += dfs(node.children.get(c));
        }
        return sum + node.value;
    }

    Map<String, Integer> map, original;

    public MapSumPairs() {
        map = new HashMap<>();
        original = new HashMap<>();
    }

    public void insert2(String key, int val) {
        val -= original.getOrDefault(key, 0);
        String s = "";
        for (char c : key.toCharArray()) {
            s += c;
            map.put(s, map.getOrDefault(s, 0) + val);
        }
        original.put(key, original.getOrDefault(key, 0) + val);
    }

    public int sum2(String prefix) {
        return map.getOrDefault(prefix, 0);
    }
}
