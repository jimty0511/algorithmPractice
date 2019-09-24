package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 930. Binary Subarrays With Sum
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int preSum = 0, res = 0, count[] = new int[A.length + 1];
        count[0] = 1;
        for (int a : A) {
            preSum += a;
            if (preSum >= S)
                res += count[preSum - S];
            count[preSum]++;
        }
        return res;
    }

    public int numSubarraysWithSumTwo(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for (int a : A) {
            sum += a;
            res += map.getOrDefault(sum - S, 0);
            if (sum == S)
                res++;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
