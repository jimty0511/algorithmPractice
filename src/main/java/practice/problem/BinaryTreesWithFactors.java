package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 823. Binary Trees With Factors
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();
        long count = 1;
        map.put(A[0], count);
        for (int i = 1; i < A.length; i++) {
            count = 1;
            for (Integer n : map.keySet()) {
                if (A[i] % n == 0 && map.containsKey(A[i] / n))
                    count += map.get(n) * map.get(A[i] / n);
            }
            map.put(A[i], count);
        }
        long sum = 0;
        for (Long v : map.values()) {
            sum = (sum + v) % ((int) 1e9 + 7);
        }
        return (int) sum;
    }
}
