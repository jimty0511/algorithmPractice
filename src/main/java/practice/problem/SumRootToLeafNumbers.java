package practice.problem;

import practice.domain.TreeNode;

import java.util.*;

// 129. Sum Root to Leaf Numbers
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        helper(root, 0, result);
//        int res = 0;
//        for (int i : result) {
//            res += i;
//        }
//        return res;
        return helperTwo(root, 0);
    }

    private void helper(TreeNode root, int sum, List<Integer> result) {
        if (root == null)
            return;
        int curSum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result.add(curSum);
            return;
        }
        if (root.left != null) {
            helper(root.left, curSum, result);
        }
        if (root.right != null) {
            helper(root.right, curSum, result);
        }
    }

    private int helperTwo(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return sum * 10 + root.val;
        return helperTwo(root.left, sum * 10 + root.val) + helperTwo(root.right, sum * 10 + root.val);
    }

    public int sumNumbersIterative(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        treeNodeStack.push(root);
        stringStack.push("" + root.val);
        int res = 0;
        while (!treeNodeStack.isEmpty()) {
            TreeNode cur = treeNodeStack.pop();
            String curStr = stringStack.pop();
            if (cur.left != null) {
                treeNodeStack.push(cur.left);
                stringStack.push(curStr + cur.left.val);
            }
            if (cur.right != null) {
                treeNodeStack.push(cur.right);
                stringStack.push(curStr + cur.right.val);
            }
            if (cur.left == null && cur.right == null)
                res += Integer.valueOf(curStr);
        }
        return res;
    }

    public int sumNumbersIterativeTwo(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        integerQueue.offer(root.val);
        int res = 0;
        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            int val = integerQueue.poll();
            if (node.left != null) {
                treeNodeQueue.offer(node.left);
                integerQueue.offer(val * 10 + node.left.val);
            }
            if (node.right != null) {
                treeNodeQueue.offer(node.right);
                integerQueue.offer(val * 10 + node.right.val);
            }
            if (node.left == null && node.right == null)
                res += val;
        }
        return res;
    }
}
