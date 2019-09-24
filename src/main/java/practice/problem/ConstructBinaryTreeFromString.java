package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 536. Construct Binary Tree from String
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        // write your code here
        if (s == null || s.length() == 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0, j = i; i < s.length(); i++, j = i) {
            char c = s.charAt(i);
            if (c == ')')
                stack.pop();
            else if ((c >= '0' && c <= '9') || c == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                    i++;
                TreeNode node = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null)
                        parent.right = node;
                    else
                        parent.left = node;
                }
                stack.push(node);
            }
        }
        return stack.isEmpty() ? null : stack.pop();
    }
}
