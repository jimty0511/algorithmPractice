package practice.problem;

import java.util.*;

// 851. Loud and Rich
public class LoudAndRich {

    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] res;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());
        for (int[] r : richer)
            map.get(r[1]).add(r[0]);
        res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++)
            res[i] = dfs(i, quiet);
        return res;
    }

    private int dfs(int i, int[] quiet) {
        if (res[i] != -1)
            return res[i];
        res[i] = i;
        if (map.get(i) != null) {
            for (int next : map.get(i)) {
                int n = dfs(next, quiet);
                if (quiet[n] < quiet[res[i]])
                    res[i] = n;
            }
        }
        return res[i];
    }
}
