package practice.problem;

import practice.domain.Node;

import java.util.LinkedList;
import java.util.Queue;

// 559. Maximum Depth of N-ary Tree
public class MaximumDepthOfNaryTree {
    public int maxDepthRecursive(Node root) {
        if (root == null)
            return 0;
        int max = 0;
        for (Node child : root.children) {
            int value = maxDepthRecursive(child);
            if (value > max) {
                max = value;
            }
        }
        return max + 1;
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                for (Node child : current.children)
                    queue.offer(child);
            }
            depth++;
        }
        return depth;
    }
}
