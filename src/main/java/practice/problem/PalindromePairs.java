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

    public List<List<Integer>> palindromePairsTwo(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2Reverse = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2Reverse) && map.get(str2Reverse) != i) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(map.get(str2Reverse));
                        temp.add(i);
                        res.add(temp);
                    }
                }
                if (isPalindrome(str2)) {
                    String str1Reverse = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1Reverse) && map.get(str1Reverse) != i && str2.length() != 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(str1Reverse));
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }

    class TrieNode {
        int id;
        TrieNode[] children;
        List<Integer> list;

        public TrieNode() {
            this.id = -1;
            this.children = new TrieNode[26];
            this.list = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairsTrie(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++)
            insert(root, words[i], i);
        for (int i = 0; i < words.length; i++)
            search(words[i], root, i, res);
        return res;
    }

    private void search(String word, TrieNode root, int idx, List<List<Integer>> res) {
        for (int i = 0; i < word.length(); i++) {
            if (root.id >= 0 && root.id != idx && isPalindromeTwo(word, i, word.length() - 1)) {
                res.add(Arrays.asList(idx, root.id));
            }
            int k = word.charAt(i) - 'a';
            root = root.children[k];
            if (root == null)
                return;
        }
        for (int i : root.list) {
            if (i == idx)
                continue;
            res.add(Arrays.asList(idx, i));
        }
    }

    private void insert(TrieNode root, String word, int idx) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int k = word.charAt(i) - 'a';
            if (node.children[k] == null)
                node.children[k] = new TrieNode();
            if (isPalindromeTwo(word, 0, i)) {
                node.list.add(idx);
            }
            node = node.children[k];
        }
        node.list.add(idx);
        node.id = idx;
    }

    private boolean isPalindromeTwo(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
