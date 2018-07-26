package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 804. Unique Morse Code Words
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : w.toCharArray()) {
                sb.append(d[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
