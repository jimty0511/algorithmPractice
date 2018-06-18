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
}
