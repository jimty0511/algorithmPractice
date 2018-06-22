package practice.problem;

// 198. House Robber
public class HouseRobber {
    public int rob(int[] nums) {
        int prevNo = 0, prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public int robTwo(int[] nums) {
        int rob = 0, notRob = 0;
        for (int i = 0; i < nums.length; i++) {
            int curRob = nums[i] + notRob;
            notRob = Math.max(notRob, rob);
            rob = curRob;
        }
        return Math.max(rob, notRob);
    }

    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] mark = new int[nums.length];
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            mark[i] = Math.max(nums[i] + mark[i - 2], mark[i - 1]);
        }
        return mark[nums.length - 1];
    }
}
