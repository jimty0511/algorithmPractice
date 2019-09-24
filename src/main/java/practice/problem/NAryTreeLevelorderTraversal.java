package practice.problem;

import practice.domain.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 429. N-ary Tree Level Order Traversal
public class NAryTreeLevelorderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node curr = q.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children) {
                    q.offer(c);
                }
            }
            res.add(curLevel);
        }
        return res;
    }
}
