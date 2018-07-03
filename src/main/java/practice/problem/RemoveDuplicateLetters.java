package practice.problem;

import java.util.Stack;

// 316. Remove Duplicate Letters
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        for (char c : chars) {
            count[c - 'a']--;
            if (visited[c - 'a'])
                continue;
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
