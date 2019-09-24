package practice.lintcode;

import java.util.HashMap;
import java.util.Map;

// 639. Word Abbreviation
public class WordAbbreviation {
    public String[] wordsAbbreviation(String[] dict) {
        // write your code here
        if (dict == null || dict.length == 0)
            return null;
        String[] ans = new String[dict.length];
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < dict.length; i++) {
            ans[i] = getAbb(dict[i], idx);
            map.put(ans[i], map.getOrDefault(ans[i], 0) + 1);
        }
        while (true) {
            boolean unique = true;
            idx++;
            for (int i = 0; i < dict.length; i++) {
                if (map.get(ans[i]) > 1) {
                    ans[i] = getAbb(dict[i], idx);
                    map.put(ans[i], map.getOrDefault(ans[i], 0) + 1);
                    unique = false;
                }
            }
            if (unique)
                break;
        }
        return ans;
    }

    private String getAbb(String word, int idx) {
        if (idx + 2 >= word.length())
            return word;
        return word.substring(0, idx) + (word.length() - idx - 1) + word.charAt(word.length() - 1);
    }
}
