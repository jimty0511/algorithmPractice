package practice.problem;

// 5. Longest Palindromic Substring
public class LongestPalindromicSubstring {
    public String longestPalindromeDp(String s) {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindromeExpand(String s) {
        int len = s.length();
        String result = null;
        int max = 0;
        if (len < 2)
            return s;
        for (int i = 0; i < len - 1; i++) {
            String s1 = longestPalindromeExpandHelper(s, i, i);
            String s2 = longestPalindromeExpandHelper(s, i, i + 1);

            if (s1.length() > max) {
                max = Math.max(s1.length(), max);
                result = s1;
            }
            if (s2.length() > max) {
                max = Math.max(s2.length(), max);
                result = s2;
            }
        }
        return result;
    }

    private String longestPalindromeExpandHelper(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
