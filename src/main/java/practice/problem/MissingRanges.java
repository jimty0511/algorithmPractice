package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 163. Missing Ranges
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long low = (long) lower, high = (long) upper;
        if (nums.length == 0) {
            getRange(low - 1, high + 1, res);
            return res;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (i == 0)
                getRange(low - 1, nums[i], res);
            else if (i == nums.length)
                getRange(nums[nums.length - 1], high + 1, res);
            else
                getRange(nums[i - 1], nums[i], res);
        }
        return res;
    }

    private void getRange(long i, long j, List<String> res) {
        if (j <= i + 1)
            return;
        if (j == i + 2)
            res.add((i + 1) + "");
        else
            res.add((i + 1) + "->" + (j - 1));
    }

    public List<String> findMissingRangesTwo(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long pre = (long) lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            long after = i == nums.length ? (long) upper + 1 : nums[i];
            if (pre + 2 == after) {
                res.add(String.valueOf(pre + 1));
            } else if (pre + 2 < after) {
                res.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
            }
            pre = after;
        }
        return res;
    }
}
