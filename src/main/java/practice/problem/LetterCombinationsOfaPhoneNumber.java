package practice.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 17. Letter Combinations of a Phone Number (backtrack)
public class LetterCombinationsOfaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(res, mapping, new StringBuilder(), digits, 0);
        return res;
    }

    private void helper(List<String> res, String[] mapping, StringBuilder cur, String digits, int idx) {
        if (cur.length() == digits.length())
            res.add(cur.toString());
        else {
            for (int i = 0; i < mapping[digits.charAt(idx) - '0'].length(); i++) {
                char c = mapping[digits.charAt(idx) - '0'].charAt(i);
                helper(res, mapping, cur.append(c), digits, idx + 1);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public List<String> letterCombinationsBfs(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String curr = ans.poll();
            String map = mapping[digits.charAt(curr.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(curr + c);
            }
        }
        return ans;
    }

    public List<String> letterCombinationsTwo(String digits) {
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        helper(0, new StringBuilder(), digits, mapping, res);
        return res;
    }

    private void helper(int idx, StringBuilder cur, String digits, String[] mapping, List<String> res) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }
        int pos = digits.charAt(idx) - '0';
        int len = cur.length();
        for (char letter : mapping[pos].toCharArray()) {
            helper(idx + 1, cur.append(letter), digits, mapping, res);
            cur.setLength(len);
        }
    }
}
