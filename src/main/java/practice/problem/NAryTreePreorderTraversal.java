package practice.problem;

import practice.domain.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//589. N-ary Tree Preorder Traversal
public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                s.add(root.children.get(i));
            }
        }
        return res;
    }

    List<Integer> recursiveRes = new ArrayList<>();

    public List<Integer> preorderRecursive(Node root) {
        if (root == null)
            return recursiveRes;
        recursiveRes.add(root.val);
        for (Node node : root.children) {
            preorderRecursive(node);
        }
        return recursiveRes;
    }
}
