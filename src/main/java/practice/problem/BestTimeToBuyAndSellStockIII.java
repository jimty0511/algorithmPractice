package practice.problem;

// 123. Best Time to Buy and Sell Stock III
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE, firstSell = 0;
        int secondBuy = Integer.MAX_VALUE, secondSell = 0;
        for (int p : prices) {
            firstBuy = Math.min(firstBuy, p);
            firstSell = Math.max(firstSell, p - firstBuy);
            secondBuy = Math.min(secondBuy, p - firstSell);
            secondSell = Math.max(secondSell, p - secondBuy);
        }
        return secondSell;
    }
}
