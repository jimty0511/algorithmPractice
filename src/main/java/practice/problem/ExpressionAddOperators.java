package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 282. Expression Add Operators
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            helper(res, path, i + 1, 0, n, digits, i + 1, target);
            if (n == 0)
                break;
        }
        return res;
    }

    private void helper(List<String> res, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
        if (pos == digits.length) {
            if (left + cur == target)
                res.add(new String(path, 0, len));
            return;
        }
        long n = 0;
        int j = len + 1;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[len] = '+';
            helper(res, path, j, left + cur, n, digits, i + 1, target);
            path[len] = '-';
            helper(res, path, j, left + cur, -n, digits, i + 1, target);
            path[len] = '*';
            helper(res, path, j, left, cur * n, digits, i + 1, target);
            if (digits[pos] == '0')
                break;
        }
    }

    public List<String> addOperatorsTwo(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        helperTwo(res, new StringBuilder(), num, 0, target, 0, 0);
        return res;
    }

    private void helperTwo(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if (pos == num.length()) {
            if (target == prev) res.add(sb.toString());
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if (pos == 0) {
                helperTwo(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                helperTwo(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                helperTwo(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                helperTwo(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }
}
