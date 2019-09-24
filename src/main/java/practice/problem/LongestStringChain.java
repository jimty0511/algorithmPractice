package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1048. Longest String Chain
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String w : words) {
            int max = 0;
            for (int i = 0; i < w.length(); i++) {
                String prev = w.substring(0, i) + w.substring(i + 1);
                max = Math.max(max, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(w, max);
            res = Math.max(res, max);
        }
        return res;
    }
}
