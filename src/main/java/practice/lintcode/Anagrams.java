package practice.lintcode;

import java.util.*;

// 171. Anagrams
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String val = String.valueOf(chars);
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(s);
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            if (e.getValue().size() > 1)
                res.addAll(e.getValue());
        }
        return res;
    }
}
