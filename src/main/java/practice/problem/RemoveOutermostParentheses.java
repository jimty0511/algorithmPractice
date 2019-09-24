package practice.problem;

// 1021. Remove Outermost Parentheses
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && open++ > 0)
                sb.append(c);
            if (c == ')' && open-- > 1)
                sb.append(c);
        }
        return sb.toString();
    }
}
