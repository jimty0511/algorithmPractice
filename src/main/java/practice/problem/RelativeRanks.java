package practice.problem;

import java.util.Arrays;

// 506. Relative Ranks
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Integer[] idx = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums[b] - nums[a]);
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                res[idx[i]] = "Gold Medal";
            else if (i == 1)
                res[idx[i]] = "Silver Medal";
            else if (i == 2)
                res[idx[i]] = "Bronze Medal";
            else
                res[idx[i]] = (i + 1) + "";
        }
        return res;
    }
}
