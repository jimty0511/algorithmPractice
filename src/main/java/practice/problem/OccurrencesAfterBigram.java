package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 1078. Occurrences After Bigram
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second))
                res.add(words[i]);
        }
        return res.toArray(new String[0]);
    }
}
