package practice.problem;

import java.util.*;

public class StringChains {
    public int longestChain(List<String> words) {
        // Write your code here
        if (words == null || words.size() == 0)
            return 0;
        int longest = 0;
        Collections.sort(words, (a, b) -> (a.length() - b.length()));
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (map.containsKey(w))
                continue;
            map.put(w, 1);
            for (int i = 0; i < w.length(); i++) {
                StringBuilder sb = new StringBuilder(w);
                sb.deleteCharAt(i);
                String temp = sb.toString();
                if (map.containsKey(temp) && map.get(temp) + 1 > map.get(w))
                    map.put(w, map.get(temp) + 1);
            }
            if (map.get(w) > longest)
                longest = map.get(w);
        }
        return longest;
    }
}
