package practice.lintcode;

import practice.domain.TreeNode;

import java.util.*;

// 1762. Climb Up
public class ClimbUp {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> parentMap = new HashMap<>();

    /**
     * @param root: the tree node
     * @param a:    the positon of Alice
     * @param b:    the position of Bob
     * @return: Can Alice win?
     */
    public boolean getWinner(TreeNode root, int a, int b) {
        // Write your code here
        buildTree(root, null);
        if (!map.containsKey(a) || !map.containsKey(b))
            return false;
        boolean aliceTurn = true;
        Set<Integer> alice = new HashSet<>(), bob = new HashSet<>(), visited = new HashSet<>();
        alice.add(a);
        bob.add(b);
        visited.add(a);
        visited.add(b);
        while (!alice.isEmpty() && !bob.isEmpty()) {
            if (aliceTurn)
                alice = walk(alice, visited);
            else
                bob = walk(bob, visited);
            aliceTurn = !aliceTurn;
        }
        return false;
    }

    private void buildTree(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        if (!map.containsKey(node.val)) {
            map.put(node.val, new ArrayList<>());
            if (parent != null) {
                map.get(node.val).add(parent.val);
                map.get(parent.val).add(node.val);
                parentMap.put(parent.val, node.val);
            }
            buildTree(node.left, node);
            buildTree(node.right, parent);
        }
    }

    private Set<Integer> walk(Set<Integer> current, Set<Integer> visited) {
        Set<Integer> res = new HashSet<>();
        for (int cur : current) {
            for (int next : map.get(cur)) {
                if (!visited.contains(next))
                    res.add(next);
            }
        }
        return res;
    }

    public boolean getWinnerTwo(TreeNode root, int a, int b) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean foundA = false, foundB = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.val == a)
                    foundA = true;
                if (cur.val == b)
                    foundB = true;

                if (foundA && foundB)
                    return true;
                else if (foundA && !foundB)
                    return true;
                else if (!foundA && foundB)
                    return false;

                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
        }
        return false;
    }
}

