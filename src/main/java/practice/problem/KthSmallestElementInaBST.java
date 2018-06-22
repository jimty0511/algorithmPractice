package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 230. Kth Smallest Element in a BST
public class KthSmallestElementInaBST {
    int kthSmallestCount = 0, kthSmallestVal = 0;
    List<Integer> kthSmallestRes = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestInorder(root, k);
        return kthSmallestVal;
    }

    private void kthSmallestInorder(TreeNode node, int k) {
        if (node != null) {
            kthSmallestInorder(node.left, k);
            kthSmallestCount++;
            if (kthSmallestCount == k) {
                kthSmallestVal = node.val;
            }
            if (kthSmallestCount > k) {
                return;
            }
            kthSmallestInorder(node.right, k);
        }
    }

    public int kthSmallestIter(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                break;
            root = root.right;
        }
        return root.val;
    }
}
