package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 947. Most Stones Removed with Same Row or Column
public class MostStonesRemovedWithSameRowOrColumn {

    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; i++)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    private int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }

    int count = 0;

    public int removeStonesTwo(int[][] stones) {
        Map<String, String> parent = new HashMap<>();
        count = stones.length;
        for (int[] stone : stones) {
            String s = stone[0] + " " + stone[1];
            parent.put(s, s);
        }
        for (int[] s1 : stones) {
            String ss1 = s1[0] + " " + s1[1];
            for (int[] s2 : stones) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) {
                    String ss2 = s2[0] + " " + s2[1];
                    union2(parent, ss1, ss2);
                }
            }
        }
        return stones.length - count;
    }

    private void union2(Map<String, String> parent, String s1, String s2) {
        String r1 = find2(parent, s1);
        String r2 = find2(parent, s2);
        if (r1.equals(r2))
            return;
        parent.put(r1, r2);
        count--;
    }

    private String find2(Map<String, String> parent, String s) {
        if (!parent.get(s).equals(s)) {
            parent.put(s, find2(parent, parent.get(s)));
        }
        return parent.get(s);
    }


    public int removeStonesDfs(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int islands = 0;
        for (int[] s : stones) {
            if (!visited.contains(s)) {
                dfs(s, visited, stones);
                islands++;
            }
        }
        return stones.length - islands;
    }

    private void dfs(int[] s1, Set<int[]> visited, int[][] stones) {
        visited.add(s1);
        for (int[] s2 : stones) {
            if (!visited.contains(s2))
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
        }
    }
}
