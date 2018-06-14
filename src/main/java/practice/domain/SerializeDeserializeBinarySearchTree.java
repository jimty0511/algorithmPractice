package practice.domain;

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
        String[] list = data.split(" ");
        TreeNode dummy = new TreeNode(0);
        deserializeDfs(list, 0, dummy, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return dummy.left;
    }

    private int deserializeDfs(String[] list, int pos, TreeNode par, boolean isLeft, int lower, int upper) {
        if (pos >= list.length)
            return pos;
        int val = Integer.valueOf(list[pos]);
        if (val < lower || val > upper)
            return pos - 1;
        TreeNode cur = new TreeNode(val);
        if (isLeft)
            par.left = cur;
        else
            par.right = cur;
        pos = deserializeDfs(list, ++pos, cur, true, lower, val);
        pos = deserializeDfs(list, ++pos, cur, false, val, upper);
        return pos;
    }
}
