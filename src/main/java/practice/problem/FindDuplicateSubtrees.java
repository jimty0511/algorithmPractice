package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 652. Find Duplicate Subtrees
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, new HashMap<>(), res);
        return res;
    }

    private String helper(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null)
            return "#";
        String serial = cur.val + "-" + helper(cur.left, map, res) + "-" + helper(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1)
            res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
