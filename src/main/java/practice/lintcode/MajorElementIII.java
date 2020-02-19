package practice.lintcode;

import java.util.*;

// 48. Majority Number III
public class MajorElementIII {
    /**
     * @param nums: A list of integers
     * @param k:    An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.keySet().size() >= k)
                removeKey(map);
        }
        if (map.size() == 0)
            return Integer.MIN_VALUE;
        for (int key : map.keySet())
            map.put(key, 0);
        for (int n : nums) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
        }
        int maxCnt = 0, res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > maxCnt) {
                maxCnt = map.get(key);
                res = key;
            }
        }
        return res;
    }

    private void removeKey(Map<Integer, Integer> map) {
        Set<Integer> set = map.keySet();
        List<Integer> removeList = new ArrayList<>();
        for (int key : set) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0)
                removeList.add(key);
        }
        for (int key : removeList)
            map.remove(key);
    }
}
