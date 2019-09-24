package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 205. Isomorphic Strings
public class IsomorphicStrings {
    public boolean isIsomorphicMap(String s, String t) {
        if (s == null || s.length() <= 1)
            return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b))
                    continue;
                else
                    return false;
            } else {
                if (!map.containsValue(b))
                    map.put(a, b);
                else
                    return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256])
                return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
