package practice.problem;

import java.util.*;

// 1081. Smallest Subsequence of Distinct Characters
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String text) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        for (int i = 0; i < text.length(); i++)
            last[text.charAt(i) - 'a'] = i;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            if (seen[c])
                continue;
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
                seen[stack.pop()] = false;
            stack.push(c);
            seen[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack)
            sb.append((char) ('a' + i));
        return sb.toString();
    }

    public String smallestSubsequenceMap(String text) {
        char[] chars = text.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        for (char c : chars)
            map.put(c, map.getOrDefault(c, 0) + 1);
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (seen.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 1) {
                char tmp = stack.pop();
                map.put(tmp, map.get(tmp) - 1);
                seen.remove(tmp);
            }
            stack.push(c);
            seen.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);
        return sb.toString();
    }
}
