package practice.problem;

public class PalindromicRanges {
    public int PalindromicRanges(int L, int R) {
        if (L > R)
            return 0;
        if (L == R)
            return 1;
        int[] dp = new int[R - L + 2];
        dp[0] = 0;
        for (int i = L; i <= R; i++) {
            dp[i - L + 1] = dp[i - L];
            if (isPalin(i))
                dp[i - L + 1]++;
        }
        int total = 0;
        for (int i = 1; i <= R - L + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int count = dp[i] - dp[j];
                if (count % 2 == 0)
                    total++;
            }
        }
        return total;
    }

    private boolean isPalin(int a) {
        String s = String.valueOf(a);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
