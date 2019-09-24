package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 1128. Number of Equivalent Domino Pairs
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            int min = Math.min(d[0], d[1]), max = Math.max(d[0], d[1]);
            int key = min * 10 + max;
            int pairs = map.getOrDefault(key, 0);
            cnt += pairs;
            map.put(key, pairs + 1);
        }
        return cnt;
    }
}
