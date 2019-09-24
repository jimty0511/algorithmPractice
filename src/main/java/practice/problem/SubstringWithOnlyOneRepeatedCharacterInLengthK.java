package practice.problem;

import java.util.*;

public class SubstringWithOnlyOneRepeatedCharacterInLengthK {
    public List<String> solution(String string, int k) {
        if (string == null || string.length() == 0)
            return null;
        List<String> res = new ArrayList<>();
        if (k == 0)
            return res;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        char[] chars = string.toCharArray();
        while (j < chars.length) {
            map.put(chars[j], map.getOrDefault(chars[j], 0) + 1);
            if (j - i == k - 1) {
                if (map.size() == k - 1)
                    res.add(string.substring(i, j));
                if (map.get(chars[i]) == 1)
                    map.remove(chars[i]);
                else
                    map.put(chars[i], map.get(chars[i]) - 1);
                i++;
            }
            j++;
        }
        return res;
    }
}
