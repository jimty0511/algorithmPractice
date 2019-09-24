package practice.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 820. Short Encoding of Words
public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            for (int i = 1; i < w.length(); i++)
                set.remove(w.substring(i));
        }
        int res = 0;
        for (String s : set)
            res += s.length() + 1;
        return res;
    }
}
