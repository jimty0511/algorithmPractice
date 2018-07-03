package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 219. Contains Duplicate II
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                if (Math.abs(i - map.get(nums[i])) <= k) {
//                    return true;
//                }
//                map.replace(nums[i], i);
//            } else {
//                map.put(nums[i], i);
//            }
//        }
//        return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
