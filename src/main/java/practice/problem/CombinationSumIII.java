package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 216. Combinations Sum III
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(k, n, result, new ArrayList<>(), 1);
        return result;
    }

    private void helper(int k, int remain, List<List<Integer>> result, List<Integer> list, int start) {
        if (list.size() == k && remain == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(k, remain - i, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
