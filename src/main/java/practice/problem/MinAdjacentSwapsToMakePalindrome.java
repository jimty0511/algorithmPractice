package practice.problem;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/351783/
public class MinAdjacentSwapsToMakePalindrome {
    public int solution(String s) {
        if (s == null || s.length() == 0 || !canMake(s))
            return -1;
        int n = s.length();
        int cnt = 0;
        char[] chars = s.toCharArray();
        boolean even = n % 2 == 0;
        for (int i = 0; i < n / 2; i++) {
            boolean found = false;
            int j = 0;
            for (j = n - 1 - j; j > i; j--) {
                if (chars[i] == chars[j]) {
                    found = true;
                    for (int k = j; k < n - 1 - i; k++) {
                        swap(chars, k, k + 1);
                        cnt++;
                    }
                    break;
                }
            }
            if (!found && !even) {
                for (int k = i; k < n / 2; k++) {
                    swap(chars, k, k + 1);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean canMake(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c))
                set.remove(c);
        }
        return set.size() == 0 || set.size() == 1;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
