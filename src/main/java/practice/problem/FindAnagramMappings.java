package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 760. Find Anagram Mappings
public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int length = A.length;
        int[] res = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < length; i++) {
            res[i] = map.get(A[i]);
        }
        return res;
    }
}
