package practice.problem;

import java.util.Arrays;

// 473. Matchsticks to Square
public class MatchsticksToSquare {
    int edge;

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int total = 0;
        for (int n : nums)
            total += n;
        if (total % 4 != 0)
            return false;
        this.edge = total / 4;
        Arrays.sort(nums);
        return helper(nums, 0, 0, new boolean[nums.length], nums.length);
    }

    private boolean helper(int[] nums, int curSum, int count, boolean[] used, int remain) {
        if (curSum == edge) {
            count++;
            if (count == 4)
                return remain == 0;
            curSum = 0;
        }
        if (curSum > edge)
            return false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (used[i])
                continue;
            if (curSum + nums[i] > edge)
                break;
            used[i] = true;
            if (helper(nums, curSum + nums[i], count, used, remain - 1))
                return true;
            used[i] = false;
        }
        return false;
    }
}
