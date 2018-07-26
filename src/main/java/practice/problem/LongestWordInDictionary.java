package practice.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 720. Longest Word in Dictionary
public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
