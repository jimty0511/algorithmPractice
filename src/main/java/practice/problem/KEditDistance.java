package practice.problem;

import java.util.ArrayList;
import java.util.List;

public class KEditDistance {
    public List<String> kDistance(String[] words, String target, int k) {
        List<String> res = new ArrayList<>();
        for (String s : words) {
            if (minDistance(s, target, k))
                res.add(s);
        }
        return res;
    }

    public boolean minDistance(String word1, String word2, int k) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n] < k;
    }
}
