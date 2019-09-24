package practice.problem;

// 45. Jump Game II
public class JumpGameII {
    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(nums[i] + i, curFarthest);
            if (i == curEnd) {
                jump++;
                curEnd = curFarthest;
                if (curEnd >= nums.length - 1)
                    break;
            }
        }
        return jump;
    }

    public int jumpBfs(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int curMax = 0, level = 0, i = 0, furthest = 0;
        while (i <= curMax) {
            level++;
            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1)
                    return level;
            }
            curMax = furthest;
        }
        return -1;
    }
}
