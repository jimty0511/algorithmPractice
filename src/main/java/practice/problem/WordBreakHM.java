package practice.problem;

import java.util.Map;

// https://leetcode.com/discuss/interview-question/338192/Facebook-or-Onsite-or-Word-Break-and-Working-and-MultiTasking-Intervals
public class WordBreakHM {
    public boolean canBreak(String str, Map<String, Integer> wordCount) {
        return helper(str, wordCount, 0);
    }

    private boolean helper(String str, Map<String, Integer> wordCount, int start) {
        if (start == str.length())
            return true;
        for (int i = start; i < str.length(); i++) {
            String word = str.substring(start, i + 1);
            if (wordCount.getOrDefault(word, -1) > 0) {
                wordCount.put(word, wordCount.get(word) - 1);
                if (helper(str, wordCount, i + 1))
                    return true;
                wordCount.put(word, wordCount.get(word) + 1);
            }
        }
        return false;
    }
}
