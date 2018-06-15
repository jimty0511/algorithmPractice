package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 266. Palindrome Permutation
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                set.remove(s.charAt(i));
        }
        return set.size() == 0 || set.size() == 1;
    }
}
