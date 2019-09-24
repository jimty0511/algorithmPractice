package practice.problem;

import java.util.*;

// 784. Letter Case Permutation
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        LinkedList<String> r = new LinkedList<>();
        r.add(S);
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                for (int size = r.size(); size > 0; size--) {
                    String s = r.poll(), left = s.substring(0, i), right = s.substring(i + 1);
                    r.add(left + Character.toLowerCase(c) + right);
                    r.add(left + Character.toUpperCase(c) + right);
                }
            }
        }
        return r;
    }

    public List<String> letterCasePermutationTwo(String S) {
        if (S == null || S.length() == 0)
            return Collections.singletonList("");
        Queue<String> q = new LinkedList<>();
        q.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i)))
                continue;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                char[] chars = cur.toCharArray();
                chars[i] = Character.toUpperCase(chars[i]);
                q.offer(String.valueOf(chars));
                chars[i] = Character.toLowerCase(chars[i]);
                q.offer(String.valueOf(chars));
            }
        }
        return new LinkedList<>(q);
    }
}
