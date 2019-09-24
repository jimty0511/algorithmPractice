package practice.problem;

import java.util.Stack;

// 394. Decode String
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        result.push("");
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int start = i;
                while (Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                count.push(Integer.valueOf(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            i++;
        }
        return result.pop();
    }

    public String decodeStringTwo(String s) {
        Stack<Integer> cnt = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                cnt.push(num);
                str.push(res);
                res = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder tmp = res;
                res = str.pop();
                int times = cnt.pop();
                while (times-- > 0)
                    res.append(tmp);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
