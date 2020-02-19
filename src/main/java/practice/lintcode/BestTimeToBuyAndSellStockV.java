package practice.lintcode;

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 1691. Best Time to Buy and Sell Stock V
public class BestTimeToBuyAndSellStockV {
    /**
     * @param nums: the array nums
     * @return: return the maximum profit
     */
    public int getAns(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
            max.offer(new int[]{nums[i], i});
        }
        int res = 0;
        while (!max.isEmpty() && !map.isEmpty()) {
            int[] sell = max.poll();
            int sellVal = sell[0], idx = sell[1];
            Map<Integer, Integer> subMap = map.subMap(0, idx);
            int buyVal = Integer.MAX_VALUE, removeKey = -1;
            for (Map.Entry<Integer, Integer> entry : subMap.entrySet()) {
                if (entry.getValue() < buyVal) {
                    buyVal = entry.getValue();
                    removeKey = entry.getKey();
                }
            }
            if (sellVal > buyVal) {
                res += sellVal - buyVal;
                map.remove(removeKey);
                map.remove(idx);
            }
        }
        return res;
    }
}
