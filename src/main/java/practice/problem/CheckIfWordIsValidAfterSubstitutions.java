package practice.problem;

import java.util.Stack;

// 1003. Check If Word Is Valid After Substitutions
public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b')
                    return false;
                if (stack.isEmpty() || stack.pop() != 'a')
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }

    public boolean isValidTwo(String S) {
        while (S.contains("abc"))
            S = S.replace("abc", "");
        return S.isEmpty();
    }
}
