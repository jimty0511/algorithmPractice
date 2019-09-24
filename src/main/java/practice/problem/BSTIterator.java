package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 173. Binary Search Tree Iterator
public class BSTIterator {

//    Stack<TreeNode> stack = null;
//
//    public BSTIterator(TreeNode root) {
//        stack = new Stack<>();
//        TreeNode cur = root;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.left;
//        }
//    }
//
//    /**
//     * @return whether we have a next smallest number
//     */
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    /**
//     * @return the next smallest number
//     */
//    public int next() {
//        TreeNode node = stack.pop();
//        TreeNode cur = node.right;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.left;
//        }
//        return node.val;
//    }

    List<Integer> list;
    int idx = -1;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return idx + 1 < list.size();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.get(++idx);
    }
}
