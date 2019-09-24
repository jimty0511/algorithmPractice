package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 1027. Longest Arithmetic Sequence
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int res = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                Map<Integer, Integer> tmp = dp.computeIfAbsent(A[j] - A[i], d -> new HashMap<>());
                tmp.put(j, tmp.getOrDefault(i, 1) + 1);
                res = Math.max(res, tmp.get(j));
            }
        }
        return res;
    }

    public int longestArithSeqLengthTwo(int[] A) {
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        int res = 2;
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int diff = A[j] - A[i];
                dp[j].put(diff, dp[i].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[j].get(diff));
            }
        }
        return res;
    }
}
