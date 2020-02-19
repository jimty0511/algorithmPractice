package practice.problem;

// 10. Regular Expression Matching
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatchTwo(String s, String p) {
        if (s == null || p == null)
            return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                if (dp[0][i - 1] || (i > 1 && dp[0][i - 2]))
                    dp[0][i] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatchThree(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = false;
                if (pp[j - 1] != '*') {
                    if (i > 0 && (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.'))
                        dp[i][j] |= dp[i - 1][j - 1];
                } else {
                    if (j > 1)
                        dp[i][j] |= dp[i][j - 2];
                    if (i > 0 && j > 1 && (pp[j - 2] == '.' || ss[i - 1] == pp[j - 2]))
                        dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
