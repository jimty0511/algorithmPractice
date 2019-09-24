package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * postorder = [9,15,7,20,3]
 * preorder = [3,9,20,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

// 889. Construct Binary Tree from Preorder and Postorder Traversal
public class ConstructBinaryTreefromPreorderandPostorderTraversal {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePostTwo(int[] pre, int[] post) {
        int len = pre.length;
        for (int i = 0; i < len; i++) {
            map.put(post[i], i);
        }
        return helper(pre, 0, len - 1, post, 0, len - 1);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart + 1 <= preEnd) {
            int leftSubRootInPost = map.get(pre[preStart + 1]);
            int sum = leftSubRootInPost - postStart;
            root.left = helper(pre, preStart + 1, preStart + 1 + sum, post, postStart, postStart + sum);
            root.right = helper(pre, preStart + sum + 2, preEnd, post, postStart + sum + 1, postEnd - 1);
        }
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; i++) {
            TreeNode node = new TreeNode(pre[i]);
            while (deque.getLast().val == post[j]) {
                deque.pollLast();
                j++;
            }
            if (deque.getLast().left == null)
                deque.getLast().left = node;
            else
                deque.getLast().right = node;
            deque.offer(node);
        }
        return deque.getFirst();
    }
}
