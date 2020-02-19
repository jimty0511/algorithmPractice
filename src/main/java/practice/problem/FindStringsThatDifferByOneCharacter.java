package practice.problem;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/382955/Airbnb-or-Phone-Screen-or-Find-Strings-That-Differ-by-1-Character
public class FindStringsThatDifferByOneCharacter {
    public boolean find(String[] strs) {
        if (strs == null || strs.length == 0)
            return false;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isValid(strs[i], strs[j]))
                    return true;
            }
        }
        return false;
    }

    private boolean isValid(String a, String b) {
        int[] cnt = new int[26];
        for (char c : a.toCharArray())
            cnt[c - 'a']++;
        for (char c : b.toCharArray())
            cnt[c - 'a']--;
        int more = 0, less = 0;
        for (int c : cnt) {
            if (c > 0)
                more++;
            if (c < 0)
                less--;
        }
        return more == 1 && less == -1;
    }

    public boolean findTwo(String[] strs) {
        if (strs == null || strs.length == 0)
            return false;
        Set<String> set = new HashSet<>();
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(0, i) + "*" + s.substring(i + 1);
                if (!set.add(tmp))
                    return true;
            }
        }
        return false;
    }
}
