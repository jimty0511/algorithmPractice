package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 90. k Sum II
public class KSumII {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        helper(A, k, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] A, int k, int target, int idx, List<Integer> tmp, List<List<Integer>> res) {
        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (k < 0 || target < 0)
            return;
        for (int i = idx; i < A.length; i++) {
            tmp.add(A[i]);
            helper(A, k - 1, target - A[i], i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
