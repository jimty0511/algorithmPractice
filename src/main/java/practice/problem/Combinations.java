package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 77. Combinations
// Microsoft ladder
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void helper(int n, int k, int idx, List<List<Integer>> res, List<Integer> temp) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i <= n; i++) {
            temp.add(i);
            helper(n, k - 1, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
