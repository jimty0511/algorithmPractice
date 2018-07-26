package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 103. Binary Tree Zigzag Level Order Traversal
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrderBfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                if (level % 2 == 0)
                    temp.add(cur.val);
                else
                    temp.add(0, cur.val);
            }
            result.add(temp);
            level++;
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrderHelper(root, res, 0);
        return res;
    }

    private void zigzagLevelOrderHelper(TreeNode curr, List<List<Integer>> list, int level) {
        if (curr == null)
            return;
        if (list.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            list.add(newLevel);
        }
        List<Integer> collection = list.get(level);
        if (level % 2 == 0)
            collection.add(curr.val);
        else
            collection.add(0, curr.val);

        zigzagLevelOrderHelper(curr.left, list, level + 1);
        zigzagLevelOrderHelper(curr.right, list, level + 1);
    }
}
