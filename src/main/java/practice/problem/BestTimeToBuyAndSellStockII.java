package practice.problem;

// 122. Best Time to Buy and Sell Stock II
public class BestTimeToBuyAndSellStockII {
    public int maxProfitTwo(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
