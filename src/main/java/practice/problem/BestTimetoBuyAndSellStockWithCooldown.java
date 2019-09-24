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

    public int maxProfitTwo(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] sell = new int[prices.length], buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfitThree(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int curSell = 0; //sell[i]
        int prevSell = 0; //sell[i-2];
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = curSell;
            curSell = Math.max(curSell, buy + prices[i]);
            buy = Math.max(buy, (i > 1 ? prevSell : 0) - prices[i]);
            prevSell = tmp;
        }
        return curSell;
    }
}
