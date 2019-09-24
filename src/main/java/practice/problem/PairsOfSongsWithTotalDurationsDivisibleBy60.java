package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 1010. Pairs of Songs With Total Durations Divisible by 60
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }

    public int numPairsDivisibleBy60Two(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60;
            ans += map.getOrDefault(d, 0);
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return ans;
    }
}
