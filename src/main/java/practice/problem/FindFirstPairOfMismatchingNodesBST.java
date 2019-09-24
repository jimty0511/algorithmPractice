package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// https://leetcode.com/discuss/interview-question/334308/Facebook-or-Onsite-or-Find-first-pair-of-mismatching-nodes
public class FindFirstPairOfMismatchingNodesBST {
    public TreeNode[] solution(TreeNode treeNode1, TreeNode treeNode2) {
        TreeNode[] res = new TreeNode[2];
        Stack<TreeNode> stk1 = new Stack<>(), stk2 = new Stack<>();
        while (!stk1.isEmpty() || treeNode1 != null) {
            while (treeNode1 != null) {
                stk1.push(treeNode1);
                treeNode1 = treeNode1.left;
                stk2.push(treeNode2);
                treeNode2 = treeNode2.left;
            }
            treeNode1 = stk1.pop();
            treeNode2 = stk2.pop();
            if (treeNode1.val != treeNode2.val) {
                res[0] = treeNode1;
                res[1] = treeNode2;
                return res;
            }
            treeNode1 = treeNode1.right;
            treeNode2 = treeNode2.right;
        }
        return res;
    }
}
