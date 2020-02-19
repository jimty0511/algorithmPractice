package practice.lintcode;

// 1417. Weighing Problem
public class WeighingProblem {
    /**
     * @param n: The number of coins
     * @return: The Minimum weighing times int worst case
     */
    public int minimumtimes(int n) {
        // Write your code here
        int ans = 0;
        if (n % 3 == 0)
            n--;
        while (n > 0) {
            n /= 3;
            ans++;
        }
        return ans;
    }
}
