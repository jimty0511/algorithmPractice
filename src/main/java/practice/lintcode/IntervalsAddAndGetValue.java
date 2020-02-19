package practice.lintcode;

import java.util.Arrays;

// 1750. intervals add and get value
public class IntervalsAddAndGetValue {
    /**
     * @param A:
     * @param operations:
     * @return: nothing
     */
    public long intervalsAddAndGetValue(int[] A, int[][] operations) {
        // Write your code here
        int[] copy = Arrays.copyOfRange(A, 0, A.length);
        long res = 0;
        for (int j = 0; j < operations.length; j++) {
            int[] o = operations[j];
            if (o[0] == 0) {
                int start = o[1], end = o[2], incre = o[3];
                for (int i = start; i <= end; i++) {
                    copy[i] += incre;
                }
            } else if (o[0] == 1) {
                int idx = o[1];
                res ^= copy[idx];
            }
        }
        return res;
    }
}
