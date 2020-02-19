package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 39. Combinations Sum
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void combinationSumHelper(List<List<Integer>> list, List<Integer> tempList,
                                      int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1])
                    continue;
                tempList.add(candidates[i]);
                combinationSumHelper(list, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
