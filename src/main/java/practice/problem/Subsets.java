package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 78. Subsets
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsetsHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            subsetsHelper(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
