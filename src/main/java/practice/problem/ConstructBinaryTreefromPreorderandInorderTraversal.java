package practice.problem;

import practice.domain.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 */

// 105. Construct Binary Tree from Preorder and Inorder Traversal
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTreeHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = buildTreeHelper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = buildTreeHelper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public TreeNode buildTreeTwo(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeTwoHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeTwoHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int leftNodes = inRoot - inStart;
        root.left = buildTreeTwoHelper(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, inRoot - 1, map);
        root.right = buildTreeTwoHelper(preorder, preStart + leftNodes + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    public TreeNode buildTreeThree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int point;
        for (point = 0; point < inorder.length; point++) {
            if (inorder[point] == rootVal)
                break;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, point);
        int[] rightInorder = Arrays.copyOfRange(inorder, point + 1, inorder.length);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, point + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, point + 1, preorder.length);

        root.left = buildTreeThree(leftPreorder, leftInorder);
        root.right = buildTreeThree(rightPreorder, rightInorder);
        return root;
    }
}
