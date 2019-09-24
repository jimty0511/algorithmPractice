package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 241. Different Ways to Add Parentheses
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }

    public List<Integer> diffWaysToComputeTwo(String input) {
        return helper(input, new HashMap<>());
    }

    private List<Integer> helper(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input))
            return map.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftRes = helper(left, map);
                List<Integer> rightRes = helper(right, map);
                for (Integer l : leftRes) {
                    for (Integer r : rightRes) {
                        int cur = 0;
                        switch (c) {
                            case '+':
                                cur = l + r;
                                break;
                            case '-':
                                cur = l - r;
                                break;
                            case '*':
                                cur = l * r;
                                break;
                        }
                        res.add(cur);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }
}
