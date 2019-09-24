package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int left = 0, right = 0, start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            right++;
            while (counter == 0) {
                char begin = s.charAt(left);
                if (map.containsKey(begin)) {
                    map.put(begin, map.get(begin) + 1);
                    if (map.get(begin) > 0)
                        counter++;
                }
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                left++;
            }
        }
        if (len == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + len);
    }

    public String minWindowTwo(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    char leftChar = s.charAt(left);
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                        if (map.get(leftChar) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
