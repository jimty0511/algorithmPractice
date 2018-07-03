package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 40. Combination Sum II
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void combinationSum2Helper(List<List<Integer>> list, List<Integer> tempList, int[] candidates,
                                       int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                combinationSum2Helper(list, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}