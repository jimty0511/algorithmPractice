package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 839. Similar String Groups
public class SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        if (A.length < 2)
            return A.length;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null)
                continue;
            String str = A[i];
            A[i] = null;
            res++;
            dfs(A, str);
        }
        return res;
    }

    private void dfs(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && helper(str, arr[i])) {
                String s = arr[i];
                arr[i] = null;
                dfs(arr, s);
            }
        }
    }

    private boolean helper(String s, String t) {
        if (s.equals(t))
            return true;
        int res = 0, i = 0;
        while (res <= 2 && i < s.length()) {
            if (s.charAt(i) != t.charAt(i))
                res++;
            i++;
        }
        return res == 2;
    }

    public int numSimilarGroupsBfs(String[] A) {
        if (A == null || A.length == 0)
            return 0;
        boolean[] visited = new boolean[A.length];
        Queue<String> q = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            ans++;
            q.offer(A[i]);
            while (!q.isEmpty()) {
                String sameGroup = q.poll();
                for (int j = 0; j < A.length; j++) {
                    if (visited[j])
                        continue;
                    int diff = 0;
                    for (int l = 0; l < A[j].length(); l++) {
                        if (sameGroup.charAt(l) != A[j].charAt(l))
                            diff++;
                    }
                    if (diff == 2 || diff == 0 && sameGroup.length() >= 2) {
                        visited[j] = true;
                        q.offer(A[j]);
                    }
                }
            }
        }
        return ans;
    }

    public int numSimilarGroupsUf(String[] A) {
        UnionFind unionFind = new UnionFind(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (helper(A[i], A[j]))
                    unionFind.union(i, j);
            }
        }
        return unionFind.size;
    }

    class UnionFind {
        int[] parents;
        int size;

        public UnionFind(int size) {
            parents = new int[size];
            this.size = size;
            for (int i = 0; i < size; i++)
                parents[i] = i;
        }

        private void union(int i, int j) {
            int x = find(parents, i);
            int y = find(parents, j);
            if (x != y) {
                parents[x] = y;
                size--;
            }
        }

        private int find(int[] parents, int v) {
            while (v != parents[v]) {
                parents[v] = parents[parents[v]];
                v = parents[v];
            }
            return v;
        }

        private int getSize() {
            return size;
        }
    }

}
