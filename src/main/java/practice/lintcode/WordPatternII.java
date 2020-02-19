package practice.lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 829. Word Pattern II
public class WordPatternII {
    /**
     * @param pattern: a string,denote pattern string
     * @param str:     a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0)
            return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        return helper(pattern, str, map, used);
    }

    private boolean helper(String pattern, String str, Map<Character, String> map, Set<String> used) {
        if (pattern.length() == 0)
            return str.length() == 0;
        char curP = pattern.charAt(0);
        if (map.containsKey(curP)) {
            if (!str.startsWith(map.get(curP)))
                return false;
            return helper(pattern.substring(1), str.substring(map.get(curP).length()), map, used);
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.length() - i - 1 < pattern.length() - 1)
                return false;
            String curWord = str.substring(0, i + 1);
            if (used.contains(curWord))
                continue;
            map.put(curP, curWord);
            used.add(curWord);
            if (helper(pattern.substring(1), str.substring(i + 1), map, used))
                return true;
            used.remove(curWord);
            map.remove(curP);
        }
        return false;
    }
}
