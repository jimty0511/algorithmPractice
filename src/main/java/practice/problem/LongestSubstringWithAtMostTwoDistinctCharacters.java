package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 159. Longest Substring with At Most Two Distinct Characters
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 1)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, maxLength = 0;
        while (high < s.length()) {
            if (map.size() <= 2) {
                char c = s.charAt(high);
                map.put(c, high);
                high++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int i : map.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                low = leftMost + 1;
            }
            maxLength = Math.max(maxLength, high - low);
        }
        return maxLength;
    }
}
