package practice.lintcode;

import java.util.Arrays;

// 1670. Turn-Based Game
public class TurnBasedGame {
    /**
     * @param atk: the atk of monsters
     * @return: Output the minimal damage QW will suffer
     */
    public long getAns(int[] atk) {
        // Write your code here
        Arrays.sort(atk);
        int sum = 0, res = 0;
        for (int a : atk)
            sum += a;
        for (int i = atk.length - 1; i >= 0; i--) {
            res += (sum -= atk[i]);
        }
        return res;
    }

    public long getAnsTwo(int[] atk) {
        Arrays.sort(atk);
        long res = 0, n = atk.length - 1;
        for (int a : atk) {
            res += a * n;
            n--;
        }
        return res;
    }
}
