package practice.lintcode;

import java.util.Arrays;

// 874. Maximum Vacation Days
public class MaximumVacationDays {
    /**
     * @param flights: the airline status from the city i to the city j
     * @param days:    days[i][j] represents the maximum days you could take vacation in the city i in the week j
     * @return: the maximum vacation days you could take during K weeks
     */
    public int maxVacationDays(int[][] flights, int[][] days) {
        // Write your code here
        int cities = flights.length, weeks = days[0].length;
        int[] dp = new int[cities];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int w = 0; w < weeks; w++) {
            int[] tmp = new int[cities];
            Arrays.fill(tmp, Integer.MIN_VALUE);
            for (int des = 0; des < cities; des++) {
                for (int source = 0; source < cities; source++) {
                    if (source == des || flights[source][des] == 1) {
                        tmp[des] = Math.max(tmp[des], dp[source] + days[des][w]);
                    }
                }
            }
            dp = tmp;
        }
        int ans = 0;
        for (int i = 0; i < cities; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    int max = Integer.MIN_VALUE;

    private void helper() {

    }
}
