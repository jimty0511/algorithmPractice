package practice.problem;

// 471. Encode String with Shortest Length
public class EncodeStringWithShortestLength {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                String subStr = s.substring(i, j + 1);
                if (j - i < 4) {
                    dp[i][j] = subStr;
                } else {
                    dp[i][j] = subStr;
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    for (int k = 0; k < subStr.length(); k++) {
                        String repeated = subStr.substring(0, k + 1);
                        if (repeated != null && subStr.length() % repeated.length() == 0
                                && subStr.replaceAll(repeated, "").length() == 0) {
                            String ss = subStr.length() / repeated.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length())
                                dp[i][j] = ss;
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
