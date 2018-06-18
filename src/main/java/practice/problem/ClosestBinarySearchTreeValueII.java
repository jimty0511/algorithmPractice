package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 272. Closest Binary Search Tree Value II
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        helper(root, target, false, s1);
        helper(root, target, true, s2);

        while (k-- > 0) {
            if (s1.isEmpty()) {
                res.add(s2.pop());
            } else if (s2.isEmpty()) {
                res.add(s1.pop());
            } else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) {
                res.add(s1.pop());
            } else {
                res.add(s2.pop());
            }
        }
        return res;
    }

    private void helper(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if (root == null) return;
        helper(reverse ? root.right : root.left, target, reverse, stack);
        if ((reverse && root.val <= target) || (!reverse && root.val > target))
            return;
        stack.push(root.val);
        helper(reverse ? root.left : root.right, target, reverse, stack);
    }

    public List<Integer> closestKValuesTwo(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        helperTwo(list, root, target, k);
        return list;
    }

    private boolean helperTwo(LinkedList<Integer> list, TreeNode root, double target, int k) {
        if (root == null)
            return false;
        if (helperTwo(list, root.left, target, k)) {
            return true;
        }
        if (list.size() == k) {
            if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
                return true;
            } else {
                list.removeFirst();
            }
        }
        list.addLast(root.val);
        return helperTwo(list, root.right, target, k);
    }

    public List<Integer> closestKValuesTwoIterative(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (res.size() == k) {
                if (Math.abs(res.getFirst() - target) <= Math.abs(root.val - target))
                    break;
                else
                    res.removeFirst();
            }
            res.offer(root.val);
            root = root.right;
        }
        return res;
    }
}
