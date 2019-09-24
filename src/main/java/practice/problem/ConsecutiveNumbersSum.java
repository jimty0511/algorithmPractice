package practice.problem;

// 829. Consecutive Numbers Sum 等差数列
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int count = 1;
        for (int k = 2; k < Math.sqrt(2 * N); k++) {
            if ((N - (k * (k - 1) / 2)) % k == 0)
                count++;
        }
        return count;
    }

    public int consecutiveNumbersSumTwo(int N) {
        int ans = 0;
        for (int m = 1; ; m++) {
            int mx = N - m * (m - 1) / 2;
            if (mx <= 0)
                break;
            if (mx % m == 0)
                ans++;
        }
        return ans;
    }
}
