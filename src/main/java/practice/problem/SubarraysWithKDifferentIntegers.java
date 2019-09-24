package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 992. Subarrays with K Different Integers
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, cnt = 0;
        while (j < A.length) {
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            if (map.size() > K) {
                map.clear();
                i++;
                j = i;
                continue;
            }
            if (map.size() == K) {
                cnt++;
                j++;
                if (j == A.length) {
                    map.clear();
                    i++;
                    j = i;
                }
                continue;
            }
            j++;
        }
        return cnt;
    }

    public int subarraysWithKDistinctTwo(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            if (map.getOrDefault(A[j], 0) == 0)
                K--;
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0)
                    K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

}
