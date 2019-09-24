package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 894. All Possible Full Binary Trees
public class AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0)
            return res;
        if (cache.containsKey(N))
            return cache.get(N);
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
            }
        }
        cache.put(N, res);
        return res;
    }
}
