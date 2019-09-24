package practice.problem;

import java.util.*;

// 500. Keyboard Row
public class KeyboardRow {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isValid(word, row1) || isValid(word, row2) || isValid(word, row3))
                res.add(word);
        }
        return res.toArray(new String[0]);
    }

    private boolean isValid(String word, Set<Character> row) {
        for (char c : word.toCharArray()) {
            if (!row.contains(Character.toLowerCase(c)))
                return false;
        }
        return true;
    }
}
