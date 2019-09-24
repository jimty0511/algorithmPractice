package practice.problem;

import java.util.*;

// 792. Number of Matching Subsequences
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<>());
        }
        for (String w : words) {
            map.get(w.charAt(0)).addLast(w);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }

    public int numMatchingSubseqTwo(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new LinkedList<>());
        }
        for (String word : words) {
            char c = word.charAt(0);
            if (map.containsKey(c))
                map.get(c).offer(word);
        }
        for (char c : S.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.length() == 1)
                    count++;
                else {
                    if (map.containsKey(str.charAt(1)))
                        map.get(str.charAt(1)).add(str.substring(1));
                }
            }
        }
        return count;
    }
}
