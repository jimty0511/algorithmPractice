package practice.problem;

import practice.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 1028. Recover a Tree From Preorder Traversal
public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length(); ) {
            int level = 0, val = 0;
            for (; S.charAt(i) == '-'; i++)
                level++;
            for (; i < S.length() && S.charAt(i) != '-'; i++)
                val = val * 10 + (S.charAt(i) - '0');
            while (stack.size() > level)
                stack.pop();
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null)
                    stack.peek().left = node;
                else
                    stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1)
            stack.pop();
        return stack.pop();
    }

    public TreeNode recoverFromPreorderTwo(String S) {
        Map<Integer, TreeNode> map = new HashMap<>();
        int i = 0;
        while (i < S.length()) {
            int curLevel = 0, curNum = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                curLevel++;
                i++;
            }
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                curNum = curNum * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(curNum);
            map.put(curLevel, node);
            if (curLevel > 0) {
                TreeNode parent = map.get(curLevel - 1);
                if (parent.left == null)
                    parent.left = node;
                else
                    parent.right = node;
            }
        }
        return map.get(0);
    }
}
