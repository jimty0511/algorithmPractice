package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 974. Subarray Sums Divisible by K
public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0)
                sum += K;
            count += map[sum];
            map[sum]++;
        }
        return count;
    }

    public int subarraysDivByKTwo(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0)
                sum += K;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
