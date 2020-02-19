package practice.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1403. Maximum Product Path
public class MaximumProductPath {

    int MOD = (int) 1e9 + 7, max = Integer.MIN_VALUE;

    /**
     * @param x: The end points of edges set
     * @param y: The end points of edges set
     * @param d: The weight of points set
     * @return: Return the maximum product
     */
    public int getProduct(int[] x, int[] y, int[] d) {
        // Write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            map.putIfAbsent(x[i], new ArrayList<>());
            map.get(x[i]).add(y[i]);
        }
        Map<Integer, Integer> weight = new HashMap<>();
        for (int i = 0; i < d.length; i++) {
            weight.put(i + 1, d[i]);
        }
        helper(1, map, weight, d[0]);
        return max;
    }

    private void helper(int node, Map<Integer, List<Integer>> map, Map<Integer, Integer> weight, long res) {
        if (!map.containsKey(node)) {
            max = (int) Math.max(max, res);
            return;
        }
        for (int next : map.get(node)) {
            helper(next, map, weight, (res * weight.get(next) + MOD) % MOD);
        }
    }
}
