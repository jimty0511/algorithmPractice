package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 617. Merge Two Binary Trees
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }

    public TreeNode mergeTreesTwo(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }
        return t1;
    }

    public TreeNode mergeTreesDfs(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] curr = stack.pop();
            if (curr[1] == null)
                continue;
            curr[0].val += curr[1].val;
            if (curr[0].left == null)
                curr[0].left = curr[1].left;
            else
                stack.push(new TreeNode[]{curr[0].left, curr[1].left});

            if (curr[0].right == null)
                curr[0].right = curr[1].right;
            else
                stack.push(new TreeNode[]{curr[0].right, curr[1].right});
        }
        return t1;
    }

    public TreeNode mergeTreesBfs(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{t1, t2});
        while (!queue.isEmpty()) {
            TreeNode[] curr = queue.poll();
            if (curr[1] == null)
                continue;
            curr[0].val += curr[1].val;
            if (curr[0].left == null)
                curr[0].left = curr[1].left;
            else
                queue.add(new TreeNode[]{curr[0].left, curr[1].left});

            if (curr[0].right == null)
                curr[0].right = curr[1].right;
            else
                queue.add(new TreeNode[]{curr[0].right, curr[1].right});
        }
        return t1;
    }

}
