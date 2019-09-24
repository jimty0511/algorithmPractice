package practice.domain;

import java.util.LinkedList;
import java.util.Queue;

// 919. Complete Binary Tree Inserter
public class CBTInserter {

//    private TreeNode root;
//    private Queue<TreeNode> q;
//
//    public CBTInserter(TreeNode root) {
//        this.root = root;
//    }
//
//    public int insert(int v) {
//        q = new LinkedList<>();
//        q.offer(root);
//        while (true) {
//            TreeNode node = q.poll();
//            if (node.left != null && node.right != null) {
//                q.offer(node.left);
//                q.offer(node.right);
//            } else {
//                if (node.left == null)
//                    node.left = new TreeNode(v);
//                else
//                    node.right = new TreeNode(v);
//                return node.val;
//            }
//        }
//    }
//
//    public TreeNode get_root() {
//        return root;
//    }

    private TreeNode root;
    private Queue<TreeNode> q;

    public CBTInserter(TreeNode root) {
        q = new LinkedList<>();
        this.root = root;
        q.offer(root);
        while (q.peek().left != null && q.peek().right != null) {
            q.offer(q.peek().left);
            q.offer(q.poll().right);
        }
    }

    public int insert(int v) {
        TreeNode node = q.peek();
        if (node.left == null) {
            node.left = new TreeNode(v);
        } else {
            node.right = new TreeNode(v);
            q.offer(node.left);
            q.offer(node.right);
            q.poll();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
