package practice.lintcode;

// 749. John's backyard garden
public class JohnsBackyardGarden {
    /**
     * @param x: the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x) {
        // write you code here
//        int[] dp = new int[x + 1];
//        dp[0] = 1;
        boolean[] dp = new boolean[x + 1];
        dp[0] = true;
        int[] bricks = new int[]{3, 7};
        for (int b : bricks) {
            for (int i = b; i <= x; i++) {
                dp[i] |= dp[i - b];
            }
        }
        return dp[x] ? "YES" : "NO";
    }
}
