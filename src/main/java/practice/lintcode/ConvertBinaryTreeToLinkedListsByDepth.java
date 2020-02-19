package practice.lintcode;

import practice.domain.ListNode;
import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 242. Convert Binary Tree to Linked Lists by Depth
public class ConvertBinaryTreeToLinkedListsByDepth {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ListNode dummy = new ListNode(0), cur = dummy;
            while (size-- > 0) {
                TreeNode node = q.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(dummy.next);
        }
        return res;
    }
}
