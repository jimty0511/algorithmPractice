package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 464. Can I Win
public class CanIWin {

    Map<String, Boolean> memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger)
            return true;
        if (((1 + maxChoosableInteger) * maxChoosableInteger / 2) < desiredTotal)
            return false;
        memo = new HashMap<>();
        return helper(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
    }

    private boolean helper(int maxChoosableInteger, int currDesiredTotal, boolean[] chosen) {
        if (currDesiredTotal <= 0)
            return false;
        String chosenStr = Arrays.toString(chosen);
        if (memo.containsKey(chosenStr))
            return memo.get(chosenStr);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (chosen[i])
                continue;
            chosen[i] = true;
            if (!helper(maxChoosableInteger, currDesiredTotal - i, chosen)) {
                memo.put(chosenStr, true);
                chosen[i] = false;
                return true;
            }
            chosen[i] = false;
        }
        memo.put(chosenStr, false);
        return false;
    }
}
