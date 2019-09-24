package practice.problem;

// 727. Minimum Window Subsequence
public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        String res = "";
        int sIndex = 0, tIndex = 0, slen = s.length, tlen = t.length, len = Integer.MAX_VALUE;
        while (sIndex < slen) {
            if (s[sIndex] == t[tIndex]) {
                tIndex++;
                if (tIndex == tlen) {
                    int end = sIndex + 1;
                    tIndex--;
                    while (tIndex >= 0) {
                        if (s[sIndex] == t[tIndex]) {
                            tIndex--;
                        }
                        sIndex--;
                    }
                    sIndex++;
                    tIndex++;
                    if (end - sIndex < len) {
                        len = end - sIndex;
                        res = S.substring(sIndex, end);
                    }
                }
            }
            sIndex++;
        }
        return len == Integer.MAX_VALUE ? "" : res;
    }

    public String minWindowDp(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        int start = 0, len = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
    }
}
