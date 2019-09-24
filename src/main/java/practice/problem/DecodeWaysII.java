package practice.problem;

public class DecodeWaysII {
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0')
            return 0;
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;
        for (int i = 2; i <= s.length(); i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);

            // For dp[i-1]
            if (second == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if (second > '0') {
                dp[i] += dp[i - 1];
            }

            // For dp[i-2]
            if (first == '*') {
                if (second == '*') {
                    dp[i] += 15 * dp[i - 2];
                } else if (second <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (first == '1' || first == '2') {
                if (second == '*') {
                    if (first == '1') {
                        dp[i] += 9 * dp[i - 2];
                    } else { // first == '2'
                        dp[i] += 6 * dp[i - 2];
                    }
                } else if (((first - '0') * 10 + (second - '0')) <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= 1000000007;
        }
        return (int) dp[s.length()];
    }

    public int numDecodingsTwo(String s) {
        int len = s.length();
        int mod = 1000000007;
        long[] dp = new long[len + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0')
            return 0;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')
                    dp[i] = dp[i - 2];
                else if (s.charAt(i - 2) == '*')
                    dp[i] = 2 * dp[i - 2];
                else
                    return 0;
            } else if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
                dp[i] = dp[i - 1];
                if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                } else if (s.charAt(i - 2) == '*') {
                    if (s.charAt(i - 1) <= '6') {
                        dp[i] = (dp[i] + dp[i - 2] * 2) % mod;
                    } else {
                        dp[i] = (dp[i] + dp[i - 2]) % mod;
                    }
                }
            } else { //s.charAt(i-1)=='*
                dp[i] = (9 * dp[i - 1]) % mod;
                if (s.charAt(i - 2) == '1') { //11-19
                    dp[i] = (dp[i] + 9 * dp[i - 2]) % mod;
                } else if (s.charAt(i - 2) == '2') { //21-26
                    dp[i] = (dp[i] + 6 * dp[i - 2]) % mod;
                } else if (s.charAt(i - 2) == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 2]) % mod;
                }
            }
        }
        return (int) dp[len];
    }
}

