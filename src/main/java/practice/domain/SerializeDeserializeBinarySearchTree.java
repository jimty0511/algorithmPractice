package practice.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinarySearchTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDfs(root, sb);
        return sb.toString();
    }

    private void serializeDfs(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val).append(" ");
        serializeDfs(root.left, sb);
        serializeDfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(" ")));
        return deserializeDfs(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeDfs(Queue<String> q, int lower, int upper) {
        if (q.isEmpty())
            return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper)
            return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserializeDfs(q, lower, val);
        root.right = deserializeDfs(q, val, upper);
        return root;
    }

    public TreeNode deserializeTwo(String data) {
        String[] strs = data.split(" ");
        Queue<Integer> q = new LinkedList<>();
        for (String s : strs) {
            q.offer(Integer.valueOf(s));
        }
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<Integer> q) {
        if (q.isEmpty())
            return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> smaller = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val)
            smaller.offer(q.poll());
        root.left = buildTree(smaller);
        root.right = buildTree(q);
        return root;
    }
}
