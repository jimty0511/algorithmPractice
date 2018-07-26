package practice.problem;

import practice.domain.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 606. Construct String from Binary Tree
public class ConstructStringFromBinaryTree {
    public String tree2strRecursion(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null) return sb.toString();
        sb.append(t.val);
        if (t.left != null) {
            sb.append("(").append(tree2strRecursion(t.left)).append(")");
        }
        if (t.right != null) {
            if (t.left == null) {
                sb.append("()");
            }
            sb.append("(").append(tree2strRecursion(t.right)).append(")");
        }
        return sb.toString();
    }

    public String tree2strIterative(TreeNode t) {
        if (t == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (set.contains(t)) {
                stack.pop();
                sb.append(")");
            } else {
                set.add(t);
                sb.append("(").append(t.val);
                if (t.left == null && t.right != null) {
                    sb.append("()");
                }
                if (t.right != null) {
                    stack.push(t.right);
                }
                if (t.left != null) {
                    stack.push(t.left);
                }
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
}
