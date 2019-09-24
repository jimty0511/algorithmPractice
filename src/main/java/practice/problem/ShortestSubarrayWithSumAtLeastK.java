package practice.problem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

// 862. Shortest Subarray with Sum at Least K
public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] sum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i <= N; i++) {
            while (d.size() > 0 && sum[i] - sum[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && sum[i] <= sum[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }

    public int shortestSubarrayTm(int[] A, int K) {
        TreeMap<Integer, Integer> preSum = new TreeMap<>();
        preSum.put(0, -1);
        int minLen = Integer.MAX_VALUE;
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            Map.Entry<Integer, Integer> entry = preSum.floorEntry(curSum - K);
            while (entry != null) {
                int key = entry.getKey();
                minLen = Math.min(minLen, i - entry.getValue());
                preSum.remove(key);
                entry = preSum.floorEntry(key);
            }
            preSum.put(curSum, i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
