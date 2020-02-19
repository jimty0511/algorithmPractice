package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 1207. Unique Number of Occurrences
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);
        return map.size() == new HashSet<Integer>(map.values()).size();
    }
}
