package practice.problem;

import practice.domain.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/347374/Google-and-Facebook-or-Validate-Single-Binary-Tree
public class ValidateBinaryTree {
    public boolean isBinaryTree(List<TreeNode> nodes) {
        Set<TreeNode> roots = new HashSet<>(), seen = new HashSet<>();
        for (TreeNode cur : nodes) {
            if (seen.contains(cur))
                continue;
            Set<TreeNode> curSeen = new HashSet<>();
            if (hasCycle(cur, roots, curSeen))
                return false;
            seen.addAll(curSeen);
            roots.add(cur);
        }
        return roots.size() == 1 && seen.size() == nodes.size();
    }

    private boolean hasCycle(TreeNode cur, Set<TreeNode> roots, Set<TreeNode> seen) {
        if (cur == null)
            return false;
        if (seen.contains(cur))
            return true;
        seen.add(cur);
        roots.remove(cur);
        return hasCycle(cur.left, roots, seen) || hasCycle(cur.right, roots, seen);
    }
}
