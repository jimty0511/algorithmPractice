package practice.lintcode;

// 1559. Take the element and query the sum
public class TakeTheElementAndQueryTheSum {
    /**
     * @param arr: the arr
     * @return: the sum
     */
    public int takeTheElementAndQueryTheSum(int[] arr) {
        // Write your code here
        int MOD = (int) 1e9 + 7;
        long[] preSum = new long[arr.length + 1];
        for (int i = arr.length - 1; i > 0; i--) {
            preSum[i] = (arr[i] + preSum[i + 1]) % MOD;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int) ((arr[i] * preSum[i + 1]) % 1000000007);
            sum = sum % 1000000007;
        }
        return sum;
    }

    public int takeTheElementAndQueryTheSumTwo(int[] arr) {
        // Write your code here
        int MOD = (int) 1e9 + 7;
        long sum = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += (sum * arr[i]) % MOD;
            ans %= MOD;
            sum += arr[i];
            sum %= MOD;
        }
        return (int) ans;
    }
}
