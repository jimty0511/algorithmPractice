package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 409. Longest Palindrome
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
