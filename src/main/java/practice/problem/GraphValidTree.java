package practice.problem;

import java.util.*;

// 261. Graph Valid Tree
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n < 1)
            return false;
        Map<Integer, Set<Integer>> adjs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjs.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            adjs.get(e[0]).add(e[1]);
            adjs.get(e[1]).add(e[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int top = queue.remove();
            if (set.contains(top))
                return false;
            for (int node : adjs.get(top)) {
                queue.add(node);
                adjs.get(node).remove(top);
            }
            set.add(top);
        }
        return set.size() == n;
    }
}
