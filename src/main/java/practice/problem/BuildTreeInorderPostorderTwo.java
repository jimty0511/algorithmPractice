package practice.problem;

import practice.domain.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 106. Construct Binary Tree from Inorder and Postorder Traversal
public class BuildTreeInorderPostorderTwo {
    public TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTreeInorderPostorderHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode buildTreeInorderPostorderHelper(int[] inorder, int inorderStart, int inorderEnd,
                                                     int[] postorder, int postorderStart, int postorderEnd,
                                                     Map<Integer, Integer> map) {
        if (postorderStart > postorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int ri = map.get(postorder[postorderEnd]);
        TreeNode leftChild = buildTreeInorderPostorderHelper(
                inorder, inorderStart, ri - 1, postorder, postorderStart, postorderStart + ri - inorderStart - 1, map);
        TreeNode rightChild = buildTreeInorderPostorderHelper(
                inorder, ri + 1, inorderEnd, postorder, postorderStart + ri - inorderStart, postorderEnd - 1, map);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public TreeNode buildTreeInorderPostorderIter(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;
        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode curr = stack.peek();
                curr.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }
        return root;
    }

    public TreeNode buildTreeInorderPostorderTwo(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        int length = inorder.length;
        if (length <= 0)
            return null;
        int rootVal = postorder[length - 1];
        int point;
        for (point = 0; point < length; point++) {
            if (inorder[point] == rootVal)
                break;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, point);
        int[] rightInorder = Arrays.copyOfRange(inorder, point + 1, length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, point);
        int[] rightPostorder = Arrays.copyOfRange(postorder, point, length - 1);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeInorderPostorderTwo(leftInorder, leftPostorder);
        root.right = buildTreeInorderPostorderTwo(rightInorder, rightPostorder);
        return root;
    }
}
