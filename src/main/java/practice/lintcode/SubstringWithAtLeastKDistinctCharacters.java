package practice.lintcode;

import java.util.HashSet;
import java.util.Set;

// 1375. Substring With At Least K Distinct Characters
public class SubstringWithAtLeastKDistinctCharacters {
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int r = i;
            while (set.size() < k && r < s.length()) {
                set.add(s.charAt(r));
                r++;
            }
            if (set.size() == k)
                cnt += s.length() - r + 1;
        }
        return cnt;
    }
}
