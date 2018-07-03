package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;
        while (end < s.length()) {
            char cEnd = s.charAt(end);
            map.put(cEnd, map.getOrDefault(cEnd, 0) + 1);
            if (map.get(cEnd) > 1)
                counter++;
            end++;

            while (counter > 0) {
                char cBegin = s.charAt(begin);
                if (map.get(cBegin) > 1)
                    counter--;
                map.put(cBegin, map.get(cBegin) - 1);
                begin++;
            }
            d = Math.max(d, end - begin);
        }
        return d;

//        int max = 0;
//        for (int i = 0, j = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                j = Math.max(j, map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i), i);
//            max = Math.max(max, i - j + 1);
//        }
//        return max;
    }

    public int lengthOfLongestSubstringTwo(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringThree(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int leftMost = 0, curr = 0, max = 1;
        while (curr < s.length()) {
            if (!set.contains(s.charAt(curr))) {
                set.add(s.charAt(curr++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(leftMost++));
            }
        }
        return max;
    }
}
