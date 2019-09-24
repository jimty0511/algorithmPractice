package practice.problem;

import practice.domain.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreePostorderTraversal {

    List<Integer> recursiveRes = new ArrayList<>();

    public List<Integer> postorderRecursive(Node root) {
        if (root == null)
            return recursiveRes;
        for (Node node : root.children) {
            postorderRecursive(node);
        }
        recursiveRes.add(root.val);
        return recursiveRes;
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.pop();
            res.addFirst(temp.val);
            for (Node n : temp.children) {
                s.push(n);
            }
        }
        return res;
    }
}
