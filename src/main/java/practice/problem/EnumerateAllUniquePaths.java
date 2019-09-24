package practice.problem;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/303107/Facebook-or-Onsite-or-Enumerate-All-Unique-Paths
public class EnumerateAllUniquePaths {
    public List<String> uniquePaths(int N) {
        List<String>[][] dp = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = new ArrayList<>();
                if (i == 0 && j == 0) {
                    dp[i][j].add("");
                } else if (i == 0) {
                    List<String> pre = dp[i][j - 1];
                    for (String p : pre) {
                        dp[i][j].add(p + "R");
                    }
                } else if (j == 0) {
                    List<String> pre = dp[i - 1][j];
                    for (String p : pre) {
                        dp[i][j].add(p + "D");
                    }
                } else {
                    List<String> pre = dp[i][j - 1];
                    for (String p : pre) {
                        dp[i][j].add(p + "R");
                    }
                    pre = dp[i - 1][j];
                    for (String p : pre) {
                        dp[i][j].add(p + "D");
                    }
                }
            }
        }
        return dp[N - 1][N - 1];
    }
}
