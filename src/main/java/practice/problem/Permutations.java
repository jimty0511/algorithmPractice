package practice.problem;

import java.util.*;

// 46. Permutations
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null)
            return res;
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited) {
        if (tmp.size() == nums.length)
            res.add(new ArrayList<>(tmp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                tmp.add(nums[i]);
                helper(res, tmp, nums, visited);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
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
