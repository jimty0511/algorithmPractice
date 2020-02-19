package practice.lintcode;

import java.util.*;

// 1666. Combination and judgment prime number
public class CombinationAndJudgmentPrimeNumber {
    /**
     * @param a: the n numbers
     * @param k: the number of integers you can choose
     * @return: how many ways that the sum of the k integers is a prime number
     */
    public int getWays(int[] a, int k) {
        // Write your code here
        boolean[] used = new boolean[a.length];
        Set<String> set = new HashSet<>();
        helper(a, k, 0, 0, used, set);
        return res;
    }

    private int res = 0;

    private void helper(int[] a, int k, int sum, int idx, boolean[] used, Set<String> set) {
        if (k == 0) {
            String cur = Arrays.toString(used);
            if (set.add(cur) && isPrime(sum))
                res++;
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!used[i]) {
                sum += a[i];
                used[i] = true;
                helper(a, k - 1, sum, i + 1, used, set);
                sum -= a[i];
                used[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2 || n % 2 == 0)
            return n == 2;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
