package practice.problem;

import java.util.Stack;

// https://leetcode.com/discuss/interview-question/340559/Airbnb-or-Online-assessment-or-Simplified-XML-Validator
public class SimplifiedXMLValidator {
    public boolean validXml(String s) {
        if (s == null || s.length() == 0)
            return false;
        Stack<String> stk = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (s.startsWith("</", idx)) {
                int j = idx + 2;
                idx = s.indexOf('>', j);
                String tag = s.substring(j, idx++);
                if (idx - 1 == j || stk.isEmpty() || !stk.pop().equals(tag))
                    return false;
            } else if (s.startsWith("<", idx)) {
                int j = idx + 1;
                idx = s.indexOf('>', j);
                if (idx == j)
                    return false;
                String tag = s.substring(j, idx++);
                stk.push(tag);
            } else
                idx++;
        }
        return stk.isEmpty();
    }
}
