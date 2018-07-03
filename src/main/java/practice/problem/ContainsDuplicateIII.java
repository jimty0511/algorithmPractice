package practice.problem;

import java.util.TreeSet;

// 220. Contains Duplicate III
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0)
            return false;
        TreeSet<Long> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = values.floor((long) nums[i]);
            Long ceil = values.ceiling((long) nums[i]);
            if ((floor != null && nums[i] - floor <= t) || (ceil != null && ceil - nums[i] <= t))
                return true;
            values.add((long) nums[i]);
            if (i >= k)
                values.remove((long) nums[i - k]);
        }
        return false;
    }
}
