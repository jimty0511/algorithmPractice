package practice.problem;

import java.util.Stack;

// 402. Remove K Digits
// Microsoft ladder
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String removeKdigitsTwo(String num, int k) {
        char[] res = new char[num.length()];
        int len = num.length() - k;
        int idx = 0;
        for (int i = 0; i < num.length(); i++) {
            while (idx > 0 && k > 0 && num.charAt(i) < res[idx - 1]) {
                idx--;
                k--;
            }
            res[idx++] = num.charAt(i);
        }
        int left = 0;
        while (left < len && res[left] == '0')
            left++;
        return left == len ? "0" : new String(res, left, len - left);
    }
}
