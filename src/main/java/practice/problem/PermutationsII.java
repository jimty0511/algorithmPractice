package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 47. Permutations II
// Microsoft ladder
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteUniqueHelper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void permuteUniqueHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                permuteUniqueHelper(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
