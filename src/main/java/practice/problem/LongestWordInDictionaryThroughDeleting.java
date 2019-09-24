package practice.problem;

import java.util.Collections;
import java.util.List;

// 524. Longest Word in Dictionary through Deleting
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWordSort(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i))
                    i++;
                if (i == dictWord.length())
                    return dictWord;
            }
        }
        return "";
    }

    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i))
                    i++;
            }
            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
            }
        }
        return longest;
    }

    public String findLongestWordThree(String s, List<String> d) {
        String longest = "";
        for (String w : d) {
            if (w.length() < longest.length() || (w.length() == longest.length() && w.compareTo(longest) > 0))
                continue;
            int i = 0, j = 0;
            while (i < s.length() && j < w.length()) {
                if (s.charAt(i) == w.charAt(j))
                    j++;
                i++;
            }
            if (j == w.length())
                longest = w;
        }
        return longest;
    }
}
