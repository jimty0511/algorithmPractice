package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 884. Uncommon Words from Two Sentences
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : (A + " " + B).split(" "))
            count.put(w, count.getOrDefault(w, 0) + 1);
        List<String> res = new ArrayList<>();
        for (String w : count.keySet()) {
            if (count.get(w) == 1)
                res.add(w);
        }
        return res.toArray(new String[0]);
    }
}
