package practice.problem;

import java.util.*;

// 819. Most Common Word
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Collections.addAll(bannedSet, banned);
        String maxWord = null;
        int maxCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if ((c != '!' && c != '?' && c != ',' && c != ';' && c != '.' && c != ' ' && c != '\'') ||
                    (c == '\'' && i != paragraph.length() - 1 && i + 1 < paragraph.length() && Character.isLetter(paragraph.charAt(i + 1)))) {
                sb.append(Character.toLowerCase(c));
            }
            if ((c == ' ' || paragraph.charAt(paragraph.length() - 1) == c) && sb.length() > 0) {
                String word = sb.toString();
                sb.setLength(0);
                if (!bannedSet.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if (map.get(word) > maxCount) {
                        maxCount = map.get(word);
                        maxWord = word;
                    }
                }
            }
        }
        return maxWord;
    }

    public String mostCommonWordTwo(String paragraph, String[] banned) {
        String[] splitedArr = paragraph.replaceAll("[!?',;.]", "").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        List<String> bannedList = Arrays.asList(banned);
        for (String str : splitedArr) {
            if (!bannedList.contains(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int currMax = 0;
        String res = "";
        for (String key : map.keySet()) {
            res = map.get(key) > currMax ? key : res;
            currMax = map.get(res);
        }
        return res;
    }
}
