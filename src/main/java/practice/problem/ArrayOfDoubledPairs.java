package practice.problem;

import java.util.TreeMap;

// 954. Array of Doubled Pairs
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : A)
            map.put(a, map.getOrDefault(a, 0) + 1);
        for (int n : map.keySet()) {
            if (map.get(n) == 0)
                continue;
            int want = n < 0 ? n / 2 : n * 2;
            if (n < 0 && n % 2 != 0 || map.get(n) > map.getOrDefault(want, 0))
                return false;
            map.put(want, map.get(want) - map.get(n));
        }
        return true;
    }
}
