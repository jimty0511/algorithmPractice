package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 199. Binary Tree Right Side View
public class BinaryTreeRightSideView {
    List<Integer> rightSideViewResult = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelper(root, 0);
        return rightSideViewResult;
    }

    private void rightSideViewHelper(TreeNode cur, int curDepth) {
        if (cur == null)
            return;
        if (curDepth == rightSideViewResult.size()) {
            rightSideViewResult.add(cur.val);
        }
        rightSideViewHelper(cur.right, curDepth + 1);
        rightSideViewHelper(cur.left, curDepth + 1);
    }

    public List<Integer> rightSideViewIter(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.right != null)
                    queue.offer(node.right);
                if (node.left != null)
                    queue.offer(node.left);
            }
        }
        return result;
    }
}
