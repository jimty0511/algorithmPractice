package practice.problem;

import java.util.Stack;

// 331. Verify Preorder Serialization of a Binary Tree
public class VerifyPreorderSequenceinBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null)
            return false;
        Stack<String> stack = new Stack<>();
        String[] strings = preorder.split(",");
        for (String s : strings) {
            while (s.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    public boolean isValidSerializationDegree(String preorder) {
        String[] strings = preorder.split(",");
        int diff = 1;
        for (String s : strings) {
            if (--diff < 0)
                return false;
            if (!s.equals("#"))
                diff += 2;
        }
        return diff == 0;
    }
}
