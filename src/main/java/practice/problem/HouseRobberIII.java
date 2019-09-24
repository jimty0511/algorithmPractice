package practice.problem;

import practice.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 337. House Robber III
public class HouseRobberIII {
    int oddValue = 0, evenValue = 0;

//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        int level = 1;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode curr = queue.poll();
//                if (curr.left != null)
//                    queue.add(curr.left);
//                if (curr.right != null)
//                    queue.add(curr.right);
//                if (level % 2 == 0) {
//                    evenValue += curr.val;
//                } else {
//                    oddValue += curr.val;
//                }
//            }
//            level++;
//        }
//        return Math.max(oddValue, evenValue);
//    }

    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

    public int robTwo(TreeNode root) {
        return helperTwo(root, new HashMap<>());
    }

    private int helperTwo(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int val = 0;
        if (root.left != null)
            val += helperTwo(root.left.left, map) + helperTwo(root.left.right, map);
        if (root.right != null)
            val += helperTwo(root.right.left, map) + helperTwo(root.right.right, map);
        val = Math.max(val + root.val, helperTwo(root.left, map) + helperTwo(root.right, map));
        map.put(root, val);
        return val;
    }
}
