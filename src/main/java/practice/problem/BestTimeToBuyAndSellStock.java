package practice.problem;

// get_max_profit
public class BestTimeToBuyAndSellStock {
    public int getMaxProfit(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int min = nums[0], profit = 0;
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            profit = Math.max(nums[i] - min, profit);
        }
        return profit;
    }
}
