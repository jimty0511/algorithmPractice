package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 982. Triples with Bitwise AND Equal To Zero
public class TriplesWithBitwiseANDEqualToZero {
    public int countTriplets(int[] A) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int num = A[i] & A[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int n : map.keySet()) {
                if ((A[i] & n) == 0)
                    ans += map.get(n);
            }
        }
        return ans;
    }
}
