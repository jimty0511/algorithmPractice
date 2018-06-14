package practice.problem;

import practice.domain.TreeNode;

import java.util.*;

// 145. Binary Tree Postorder Traversal
public class BinaryTreePostTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(0, root.val);
            if (root.left != null)
                stack.add(root.left);
            if (root.right != null)
                stack.add(root.right);
        }
        return result;
    }

    public List<Integer> postorderTraversalTwo(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }
}
