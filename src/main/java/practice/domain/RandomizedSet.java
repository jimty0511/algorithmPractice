package practice.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// 380. Insert Delete GetRandom O(1)
public class RandomizedSet {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> map;
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (contain)
            return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain)
            return false;
        int curIdx = map.get(val);
        if (curIdx < nums.size() - 1) {
            int curLastNum = nums.get(nums.size() - 1);
            nums.set(curIdx, curLastNum);
            map.put(curLastNum, curIdx);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
