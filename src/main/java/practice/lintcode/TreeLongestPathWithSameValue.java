package practice.lintcode;

import java.util.*;

// 717. Tree Longest Path With Same Value
public class TreeLongestPathWithSameValue {
    public int LongestPathWithSameValue(int[] A, int[] E) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = E.length;
        for (int i = 0; i < n; i += 2) {
            map.putIfAbsent(E[i] - 1, new ArrayList<>());
            map.get(E[i] - 1).add(E[i + 1] - 1);
            map.putIfAbsent(E[i + 1] - 1, new ArrayList<>());
            map.get(E[i + 1] - 1).add(E[i] - 1);
        }
        int m = A.length, res = 0;
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            res = Math.max(res, helper(i, A, map, set, 0));
        }
        return res;
    }

    private int helper(int idx, int[] A, Map<Integer, List<Integer>> map, Set<Integer> set, int dis) {
        if (!map.containsKey(idx))
            return 0;
        int ans = -1;
        List<Integer> cur = map.get(idx);
        for (int next : cur) {
            if (A[next] == A[idx] && !set.contains(next)) {
                set.add(next);
                ans = Math.max(ans, helper(next, A, map, set, dis + 1));
                set.remove(next);
            }
        }
        return ans == -1 ? dis : ans;
    }
}
