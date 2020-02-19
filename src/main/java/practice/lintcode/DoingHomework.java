package practice.lintcode;

import java.util.Arrays;

// 1753. Doing Homework
public class DoingHomework {
    /**
     * @param cost: the cost
     * @param val:  the val
     * @return: the all cost
     */
    public long doingHomework(int[] cost, int[] val) {
        // Write your code here.
        int m = cost.length, n = val.length;
        long res = 0;
        long[] preSum = new long[m + 1];
        for (int i = 1; i <= m; i++)
            preSum[i] = preSum[i - 1] + cost[i - 1];
        for (int v : val) {
            int idx = Arrays.binarySearch(preSum, v);
            if (idx < 0) {
                idx = -(idx + 2);
            }
            res += preSum[idx];
        }
        return res;
    }
}
