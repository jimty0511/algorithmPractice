package practice.domain;

import java.util.*;

// 381. Insert Delete GetRandom O(1) - Duplicates allowed
public class InsertDeleteGetRandomOOneDuplicatesAllowed {

    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    Random ran;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomOOneDuplicatesAllowed() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        ran = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        map.putIfAbsent(val, new LinkedHashSet<>());
        map.get(val).add(nums.size());
        nums.add(val);
        return !contains;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0)
            return false;
        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);
        int lastNum = nums.get(nums.size() - 1);
        nums.set(removeIdx, lastNum);
        map.get(lastNum).add(removeIdx);
        map.get(lastNum).remove(nums.size() - 1);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get(ran.nextInt(nums.size()));
    }
}
