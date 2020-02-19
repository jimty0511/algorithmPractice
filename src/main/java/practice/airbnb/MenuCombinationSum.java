package practice.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://github.com/allaboutjst/airbnb/blob/master/src/main/java/menu_combination_sum/MenuCombinationSum.java
// https://leetcode.com/discuss/interview-question/124782/Airbnb-or-Phone-screen-or-Combination-Sum
public class MenuCombinationSum {
    public List<List<Double>> solution(double[] prices, double target) {
        List<List<Double>> res = new ArrayList<>();
        Arrays.sort(prices);
        int[] intPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            intPrices[i] = (int) Math.round(prices[i] * 100);
        }
        int intTarget = (int) Math.round(target * 100);
        helper(res, new ArrayList<>(), prices, intPrices, intTarget, 0);
        return res;
    }

    private void helper(List<List<Double>> res, List<Double> cur, double[] prices, int[] intPrices, int target, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = idx; i < intPrices.length; i++) {
            if (i > idx && intPrices[i] == intPrices[i - 1])
                continue;
            if (intPrices[i] > target)
                break;
            cur.add(prices[i]);
            helper(res, cur, prices, intPrices, target - intPrices[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
