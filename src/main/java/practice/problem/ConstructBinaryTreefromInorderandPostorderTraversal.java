package practice.problem;

import practice.domain.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

// 106. Construct Binary Tree from Inorder and Postorder Traversal
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
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
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }

    public TreeNode buildTreeTwo(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeTwoHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeTwoHelper(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int point = map.get(root.val);
        root.left = buildTreeTwoHelper(postorder, postStart, postStart + point - inStart - 1, inorder, inStart, point - 1, map);
        root.right = buildTreeTwoHelper(postorder, postStart + point - inStart, postEnd - 1, inorder, point + 1, inEnd, map);
        return root;
    }

}
