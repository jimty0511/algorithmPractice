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

    public int maxProfitTwoII(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i])
                i++;
            buy = prices[i];
            while (i < N && prices[i + 1] > prices[i])
                i++;
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;
    }
}
