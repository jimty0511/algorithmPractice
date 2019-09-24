package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 267. Palindrome Permutation II
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        List<String> res = new ArrayList<>();
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
            odd += map[c] % 2 != 0 ? 1 : -1;
        }
        if (odd > 1)
            return res;
        String mid = "";
        int halfLen = 0;
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                if (map[i] % 2 != 0) {
                    mid = "" + (char) i;
                    map[i]--;
                }
                map[i] /= 2;
                halfLen += map[i];
            }
        }
        helper(map, halfLen, "", mid, res);
        return res;

    }

    private void helper(int[] map, int halfLen, String s, String mid, List<String> res) {
        if (s.length() == halfLen) {
            StringBuilder reverse = new StringBuilder(s).reverse();
            res.add(s + mid + reverse.toString());
            return;
        }
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                map[i]--;
                helper(map, halfLen, s + (char) i, mid, res);
                map[i]++;
            }
        }
    }

    public List<String> generatePalindromesTwo(String s) {
        int odd = 0;
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
        if (odd > 1)
            return res;
        String mid = "";
        int halfLen = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) {
                mid = "" + (char) key;
                entry.setValue(0);
            }
            int halfVal = val / 2;
            halfLen += halfVal;
            entry.setValue(halfVal);
        }
        helperTwo(map, halfLen, "", mid, res);
        return res;
    }

    private void helperTwo(Map<Character, Integer> map, int halfLen, String s, String mid, List<String> res) {
        if (s.length() == halfLen) {
            StringBuilder reverse = new StringBuilder(s).reverse();
            res.add(s + mid + reverse.toString());
            return;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                helperTwo(map, halfLen, s + (char) entry.getKey(), mid, res);
                entry.setValue(entry.getValue() + 1);
            }
        }
    }
}
