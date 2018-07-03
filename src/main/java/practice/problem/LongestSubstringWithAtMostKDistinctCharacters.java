package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 340. Longest Substring with At Most K Distinct Characters
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() < 1)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, maxLength = 0;
        while (high < s.length()) {
            if (map.size() <= k) {
                char c = s.charAt(high);
                map.put(c, high);
                high++;
            }
            if (map.size() > k) {
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