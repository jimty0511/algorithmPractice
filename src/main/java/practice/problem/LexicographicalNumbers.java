package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 386. Lexicographical Numbers
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            helper(i, n, res);
        }
        return res;
    }

    private void helper(int cur, int n, List<Integer> res) {
        if (cur > n)
            return;
        else {
            res.add(cur);
            for (int i = 0; i < 10; i++) {
                if (10 * cur + i > n)
                    return;
                helper(10 * cur + i, n, res);
            }
        }
    }
}
