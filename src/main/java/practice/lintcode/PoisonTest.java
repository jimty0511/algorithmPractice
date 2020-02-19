package practice.lintcode;

// 1568. Poison Test
public class PoisonTest {
    /**
     * @param n: There are n bottles of water
     * @return: Return the number of mice
     */
    public int getAns(int n) {
        // Write your code here
        int ans = 1;
        int sign = 0;
        while (ans < n) {
            ans *= 2;
            sign++;
        }
        return sign;
    }
}
