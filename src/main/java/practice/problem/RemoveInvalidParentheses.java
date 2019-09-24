package practice.problem;

import java.util.*;

// 301. Remove Invalid Parentheses
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (s == null)
            return res;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (isValid(cur.toCharArray())) {
                    found = true;
                    res.add(cur);
                }
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) != '(' && cur.charAt(i) != ')')
                        continue;
                    String tmp = cur.substring(0, i) + cur.substring(i + 1);
                    if (visited.add(tmp))
                        q.offer(tmp);
                }
            }
            if (found)
                break;
        }
        return res;
    }

    private boolean isValid(char[] chars) {
        int cnt = 0;
        for (char c : chars) {
            if (c == '(')
                cnt++;
            else if (c == ')' && cnt-- == 0)
                return false;
        }
        return cnt == 0;
    }

    public List<String> removeInvalidParenthesesBfs(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (removeInvalidParenthesesBfsIsValid(s)) {
                result.add(s);
                found = true;
            }
            if (found)
                continue;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')')
                    continue;
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return result;
    }

    private boolean removeInvalidParenthesesBfsIsValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                count++;
            if (c == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }

    public List<String> removeInvalidParenthesesDfs(String s) {
        List<String> result = new ArrayList<>();
        removeInvalidParenthesesDfsHelper(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    private void removeInvalidParenthesesDfsHelper(String s, List<String> result, int lastI, int lastJ, char[] par) {
        for (int stack = 0, i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0])
                stack++;
            if (s.charAt(i) == par[1])
                stack--;
            if (stack >= 0)
                continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    removeInvalidParenthesesDfsHelper(s.substring(0, j) + s.substring(j + 1), result, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')
            removeInvalidParenthesesDfsHelper(reversed, result, 0, 0, new char[]{')', '('});
        else
            result.add(reversed);
    }
}
