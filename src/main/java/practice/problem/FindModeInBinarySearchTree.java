package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 501. Find Mode in Binary Search Tree
public class FindModeInBinarySearchTree {

    Integer prev = null;
    int count = 1, max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        helper(root.left, list);
        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        helper(root.right, list);
    }

    public int[] findModeMap(TreeNode root) {
        if (root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        mapHelper(root, map);
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                list.add(key);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void mapHelper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, map.get(root.val));
        mapHelper(root.left, map);
        mapHelper(root.right, map);
    }
}
