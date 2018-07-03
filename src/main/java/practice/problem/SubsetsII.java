package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90. Subsets II
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            tempList.add(nums[i]);
            subsetsWithDupHelper(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
