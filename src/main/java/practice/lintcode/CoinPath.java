package practice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 866. Coin Path
public class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        // write your code here
        int n = A.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        List<Integer> path = new ArrayList<>();
        Arrays.fill(dp, -1);
        Arrays.fill(next, -1);
        dp[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] != -1) {
                for (int j = i + 1; j <= i + B && j < n; j++) {
                    if (dp[j] != -1) {
                        if (dp[i] == -1 || dp[j] + A[i] < dp[i]) {
                            dp[i] = dp[j] + A[i];
                            next[i] = j;
                        }
                    }
                }
            }
        }
        if (dp[0] == -1)
            return path;
        int cur = 0;
        while (cur != -1) {
            path.add(cur + 1);
            cur = next[cur];
        }
        return path;
    }
}
