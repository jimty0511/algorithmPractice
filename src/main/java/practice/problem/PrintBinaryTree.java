package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 655. Print Binary Tree
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, cols = (int) (Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < cols; i++)
            row.add("");
        for (int i = 0; i < rows; i++)
            result.add(new ArrayList<>(row));
        helper(root, result, 0, rows, 0, cols - 1);
        return result;
    }

    private void helper(TreeNode root, List<List<String>> result, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null)
            return;
        result.get(row).set((i + j) / 2, Integer.toString(root.val));
        helper(root.left, result, row + 1, totalRows, i, (i + j) / 2);
        helper(root.right, result, row + 1, totalRows, (i + j) / 2 + 1, j);
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + (Math.max(getHeight(root.left), getHeight(root.right)));
    }

    public List<List<String>> printTreeIterative(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null)
            return result;
        int rows = getHeight(root);
        int cols = (int) (Math.pow(2, rows) - 1);
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            result.add(row);
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<int[]> indexes = new LinkedList<>();
        treeNodeQueue.add(root);
        indexes.add(new int[]{0, cols - 1});
        int row = -1;
        while (!treeNodeQueue.isEmpty()) {
            row++;
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = treeNodeQueue.poll();
                int[] index = indexes.poll();
                if (cur == null)
                    continue;
                int left = index[0];
                int right = index[1];
                int mid = left + (right - left) / 2;
                result.get(row).set(mid, Integer.toString(cur.val));
                treeNodeQueue.add(cur.left);
                treeNodeQueue.add(cur.right);
                indexes.add(new int[]{left, mid - 1});
                indexes.add(new int[]{mid + 1, right});
            }
        }
        return result;
    }
}
