package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 1124. Longest Well-Performing Interval
public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0)
                res = i + 1;
            else {
                map.putIfAbsent(score, i);
                if (map.containsKey(score - 1))
                    res = Math.max(res, i - map.get(score - 1));
            }
        }
        return res;
    }
}
