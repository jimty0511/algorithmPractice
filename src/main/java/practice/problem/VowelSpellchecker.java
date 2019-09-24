package practice.problem;

import java.util.*;

// 966. Vowel Spellchecker
public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> cap = new HashMap<>(), vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase(), deVowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(deVowel, w);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i]))
                continue;
            String lower = queries[i].toLowerCase(), deVowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower))
                queries[i] = cap.get(lower);
            else if (vowel.containsKey(deVowel))
                queries[i] = vowel.get(deVowel);
            else
                queries[i] = "";
        }
        return queries;
    }
}
