package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 294. Flip Game II
public class FlipGameII {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2)
            return false;
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    public boolean helper(String s, Map<String, Boolean> map) {
        if (map.containsKey(s))
            return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(t, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
