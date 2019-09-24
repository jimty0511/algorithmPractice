package practice.lintcode;

import java.util.Stack;

// 823. Input Stream
public class InputStream {
    public String inputStream(String inputA, String inputB) {
        // Write your code here
        Stack<Character> s1 = new Stack<>(), s2 = new Stack<>();
        for (char c : inputA.toCharArray()) {
            if (c != '<')
                s1.push(c);
            else if (!s1.isEmpty())
                s1.pop();
        }
        for (char c : inputB.toCharArray()) {
            if (c != '<')
                s2.push(c);
            else if (!s2.isEmpty())
                s2.pop();
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() != s2.peek())
                return "NO";
            s1.pop();
            s2.pop();
        }
        if (!s1.isEmpty() || !s2.isEmpty())
            return "NO";
        return "YES";
    }
}
