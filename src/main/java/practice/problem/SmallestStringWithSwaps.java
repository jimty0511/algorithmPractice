package practice.problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 1202. Smallest String With Swaps
public class SmallestStringWithSwaps {

    private int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0)
            return null;

        parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        for (List<Integer> p : pairs) {
            union(p.get(0), p.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();
    }

    private int find(int val) {
        while (parent[val] != val) {
            parent[val] = parent[parent[val]];
            val = parent[val];
        }
        return val;
    }

    private void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent < bParent)
            parent[bParent] = aParent;
        else
            parent[aParent] = bParent;
    }
}
