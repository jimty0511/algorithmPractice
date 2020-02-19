package practice.lintcode;

import java.util.Arrays;

// 1692. Team squad
public class TeamSquad {
    /**
     * @param atk1: the power of heros
     * @param atk2: the power of monsters
     * @return: how many monsters can you kill at most?
     */
    public int getAns(int[] atk1, int[] atk2) {
        // Write your code here
        Arrays.sort(atk1);
        Arrays.sort(atk2);
        int i = 0, j = 0, res = 0;
        while (i < atk1.length && j < atk2.length) {
            if (atk1[i] > atk2[j]) {
                i++;
                j++;
                res++;
            } else if (atk1[i] <= atk2[j]) {
                i++;
            }
        }
        return res;
    }
}
