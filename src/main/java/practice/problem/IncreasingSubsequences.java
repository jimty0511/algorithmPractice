package practice.problem;

import java.util.*;

// 491. Increasing Subsequences
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new LinkedList<>(), 0, nums, res);
        return res;
    }

    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
        if (list.size() > 1)
            res.add(new LinkedList<>(list));
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i]))
                continue;
            if (list.size() == 0 || nums[i] >= list.peekLast()) {
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list, i + 1, nums, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequencesTwo(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helperTwo(res, nums, 0, new LinkedList<>());
        return new ArrayList<>(res);
    }

    private void helperTwo(Set<List<Integer>> res, int[] nums, int idx, LinkedList<Integer> tmp) {
        if (tmp.size() > 1)
            res.add(new LinkedList<>(tmp));
        for (int i = idx; i < nums.length; i++) {
            if (tmp.isEmpty() || tmp.peekLast() <= nums[i]) {
                tmp.add(nums[i]);
                helperTwo(res, nums, i + 1, tmp);
                tmp.removeLast();
            }
        }
    }
}
