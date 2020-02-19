package practice.lintcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// 1748. Longest Common SubsequenceIII
public class LongestCommonSubsequenceIII {
    /**
     * @param A:
     * @param B:
     * @return: nothing
     */
    public int longestCommonSubsequenceIII(int[] A, int[] B) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++)
            map.put(B[i], i);
        int[] tmp = new int[A.length];
        int idx = 0;
        for (int a : A) {
            tmp[idx++] = map.get(a);
        }
        int size = 0;
        int[] tails = new int[A.length];
        for (int n : tmp) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < n) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = n;
            if (i == size)
                ++size;
        }
        return size;
    }

    public int longestCommonSubsequenceIIITwo(int[] A, int[] B) {
        // Write your code here
        if (A.length == 0 || B.length == 0)
            return 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[A.length][B.length];
    }
}
