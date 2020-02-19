package practice.problem;

// 1191. K-Concatenation Maximum Sum
public class KConcatenationMaximumSum {

    int MOD = (int) 1e9 + 7;

    public int kConcatenationMaxSum(int[] arr, int k) {
        long maxInArr = maxInArr(arr);
        if (k == 1)
            return (int) maxInArr;
        long prefix = maxPrefix(arr);
        long suffix = maxSuffix(arr);
        long sum = 0;
        for (int a : arr)
            sum += a;
        if (sum > 0)
            return (int) (Math.max(maxInArr % MOD, (prefix % MOD + suffix % MOD + (sum * (k - 2)) % MOD) % MOD));
        else
            return (int) (Math.max(maxInArr % MOD, (prefix % MOD + suffix % MOD) % MOD));
    }

    private long maxInArr(int[] arr) {
        int curSum = 0, max = Integer.MIN_VALUE;
        for (int a : arr) {
            curSum = curSum > 0 ? (curSum + a) % MOD : a;
            max = Math.max(curSum, max);
        }
        return max < 0 ? 0 : max % MOD;
    }

    private long maxPrefix(int[] arr) {
        int curSum = 0, max = Integer.MIN_VALUE;
        for (int a : arr) {
            curSum = (curSum + a) % MOD;
            max = Math.max(curSum, max);
        }
        return max;
    }

    private long maxSuffix(int[] arr) {
        int curSum = 0, max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            curSum = (curSum + arr[i]) % MOD;
            max = Math.max(curSum, max);
        }
        return max;
    }
}
