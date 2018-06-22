package practice.problem;

import java.util.*;

// 336. Palindrome Pairs
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0)
            return result;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        if (map.containsKey("")) {
            int emptyIdx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i == emptyIdx)
                    continue;
                if (isPalindrome(words[i])) {
                    result.add(Arrays.asList(i, emptyIdx));
                    result.add(Arrays.asList(emptyIdx, i));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String curReverse = reverseString(words[i]);
            if (map.containsKey(curReverse)) {
                int found = map.get(curReverse);
                if (found == i)
                    continue;
                result.add(Arrays.asList(i, found));
            }
        }

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int cut = 1; cut < curr.length(); cut++) {
                if (isPalindrome(curr.substring(0, cut))) {
                    String cutReverse = reverseString(curr.substring(cut));
                    if (map.containsKey(cutReverse)) {
                        int found = map.get(cutReverse);
                        if (found == i)
                            continue;
                        result.add(Arrays.asList(found, i));
                    }
                }
                if (isPalindrome(curr.substring(cut))) {
                    String cutReverse = reverseString(curr.substring(0, cut));
                    if (map.containsKey(cutReverse)) {
                        int found = map.get(cutReverse);
                        if (found == i)
                            continue;
                        result.add(Arrays.asList(i, found));
                    }
                }
            }
        }

        return result;
    }

    private String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
