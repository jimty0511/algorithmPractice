package practice.problem;

// 730. Count Different Palindromic Subsequences
public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String S) {
        int len = S.length(), mod = (int) 1e9 + 7;
        int[][] dp = new int[len][len];
        char[] chs = S.toCharArray();
        for (int i = 0; i < len; i++)
            dp[i][i] = 1;
        for (int distance = 1; distance < len; distance++) {
            for (int i = 0; i < len - distance; i++) {
                int j = i + distance;
                if (chs[i] == chs[j]) {
                    int low = i + 1, high = j - 1;
                    while (low <= high && chs[low] != chs[j])
                        low++;
                    while (low <= high && chs[high] != chs[j])
                        high--;
                    if (low > high)
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    else if (low == high)
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    else
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j] % mod;
            }
        }
        return dp[0][len - 1];
    }
}
