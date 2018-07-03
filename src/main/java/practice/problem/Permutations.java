package practice.problem;

import java.util.*;

// 46. Permutations
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteBacktrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void permuteBacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                permuteBacktrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteIterative(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int l = nums.length;
        if (nums == null || l == 0)
            return list;

        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int n : nums) {
            queue.offer(Arrays.asList(n));
        }

        while (!queue.isEmpty()) {
            List<Integer> next = queue.poll();
            if (l == next.size()) {
                list.add(next);
                continue;
            }
            for (int n : nums) {
                if (!next.contains(n)) {
                    List<Integer> u = new ArrayList<>(next);
                    u.add(n);
                    queue.offer(u);
                }
            }
        }
        return list;
    }
}
