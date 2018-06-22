package practice.problem;

// 309. Best Time to Buy and Sell Stock with Cooldown
public class BestTimetoBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy;
        for (int p : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - p, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + p, prevSell);
        }
        return sell;
    }
}
