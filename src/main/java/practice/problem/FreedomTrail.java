package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 514. Freedom Trail
public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        int[][] dp = new int[m + 1][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        return dp[0][0] + m;
    }

    public int findRotateStepsTwo(String ring, String key) {
        Map<String, Integer> map = new HashMap<>();
        return helper(ring, key, 0, map);
    }

    private int helper(String ring, String key, int idx, Map<String, Integer> map) {
        if (idx == key.length())
            return 0;
        char c = key.charAt(idx);
        String hashKey = ring + idx;
        if (map.containsKey(hashKey))
            return map.get(hashKey);
        int minStep = Integer.MAX_VALUE;
        int first = ring.indexOf(c);
        int last = ring.lastIndexOf(c);
        for (int i = 0; i < ring.length(); i++) {
            if (i == first || i == last) {
                String s = ring.substring(i) + ring.substring(0, i);
                int steps = 1 + Math.min(i, ring.length() - i);
                steps += helper(s, key, idx + 1, map);
                minStep = Math.min(minStep, steps);
            }
        }
        map.put(hashKey, minStep);
        return minStep;
    }
}
