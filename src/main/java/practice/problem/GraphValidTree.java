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

    public boolean validTreeUf(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x == y)
                return false;
            nums[x] = y;
        }
        return edges.length == n - 1;
    }

    private int find(int nums[], int i) {
        if (nums[i] == -1)
            return i;
        return find(nums, nums[i]);
    }

    public boolean validTreeTwo(int n, int[][] edges) {
        int len = edges.length;
        if (len != n - 1)
            return false;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++)
            nums[i] = i;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (findTwo(nums, from) == findTwo(nums, to))
                return false;
            union(from, to, nums);
        }
        return true;
    }

    private int findTwo(int[] parent, int i) {
        while (i != parent[i])
            i = parent[i];
        return i;
    }

    private void union(int a, int b, int[] parent) {
        int aParent = find(parent, a);
        int bParent = find(parent, b);
        if (aParent == bParent)
            return;
        parent[aParent] = bParent;
    }
}
