package practice.problem;

// 5. Longest Palindromic Substring
// Microsoft ladder
public class LongestPalindromicSubstring {
    public String longestPalindromeDp(String s) {
        if (s == null || s.length() == 0)
            return "";
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

    public String longestPalindromeDpTwo(String s) {
        if (s == null || s.length() == 0)
            return "";
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
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

    public String longestPalindromeOn(String s) {
        if (s == null || s.length() == 0)
            return "";
        String str = generateString(s);
        int[] palindrome = new int[str.length()];
        int mid = 0, longest = 1;
        palindrome[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            int len = 1;
            if (mid + longest > i) {
                int mirrorOfI = mid - (i - mid);
                len = Math.min(palindrome[mirrorOfI], mid + longest - i);
            }
            while (i + len < str.length() && i - len >= 0) {
                if (str.charAt(i - len) != str.charAt(i + len)) {
                    break;
                }
                len++;
            }
            if (len > longest) {
                longest = len;
                mid = i;
            }
            palindrome[i] = len;
        }
        longest = longest - 1;
        int start = (mid - 1) / 2 - (longest - 1) / 2;
        return s.substring(start, start + longest);
    }

    private String generateString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#");
        return sb.toString();
    }
}
