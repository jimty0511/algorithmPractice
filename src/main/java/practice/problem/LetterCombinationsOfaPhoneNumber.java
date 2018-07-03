package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 17. Letter Combinations of a Phone Number (backtrack)
public class LetterCombinationsOfaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        String[] numToLetters = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String curr = "";
        letterCombinationsHelper(result, numToLetters, curr, digits, 0);
        return result;
    }

    private void letterCombinationsHelper(List<String> result, String[] numToLetters, String curr,
                                          String digits, int pos) {
        if (curr.length() == digits.length())
            result.add(new String(curr));
        else {
            for (int i = 0; i < numToLetters[digits.charAt(pos) - '1'].length(); i++) {
                curr += "" + numToLetters[digits.charAt(pos) - '1'].charAt(i);
                letterCombinationsHelper(result, numToLetters, curr, digits, pos + 1);
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
}
