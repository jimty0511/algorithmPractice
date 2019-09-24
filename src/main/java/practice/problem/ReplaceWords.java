package practice.problem;

import practice.domain.TrieNodeLeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 648. Replace Words
public class ReplaceWords {
    public String replaceWordsSet(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0)
            return sentence;
        Set<String> set = new HashSet<>();
        for (String s : dict)
            set.add(s);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        for (String w : words) {
            String prefix = "";
            for (int i = 1; i <= w.length(); i++) {
                prefix = w.substring(0, i);
                if (set.contains(prefix))
                    break;
            }
            sb.append(" ").append(prefix);
        }
        return sb.deleteCharAt(0).toString();
    }

    public String replaceWordsTwo(List<String> dict, String sentence) {
        dict.sort((a, b) -> a.length() - b.length());
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (String root : dict) {
                if (w.startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public String replaceWordsTrie(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNodeLeetCode trie = buildTrie(dict);
        return helper(tokens, trie);
    }

    private String helper(String[] tokens, TrieNodeLeetCode root) {
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(getShorest(token, root));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String getShorest(String token, TrieNodeLeetCode root) {
        TrieNodeLeetCode tmp = root;
        StringBuilder sb = new StringBuilder();
        for (char c : token.toCharArray()) {
            sb.append(c);
            if (tmp.children[c - 'a'] != null) {
                if (tmp.children[c - 'a'].isWord)
                    return sb.toString();
                tmp = tmp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    private TrieNodeLeetCode buildTrie(List<String> dict) {
        TrieNodeLeetCode root = new TrieNodeLeetCode(' ');
        for (String word : dict) {
            TrieNodeLeetCode tmp = root;
            for (char c : word.toCharArray()) {
                if (tmp.children[c - 'a'] == null)
                    tmp.children[c - 'a'] = new TrieNodeLeetCode('c');
                tmp = tmp.children[c - 'a'];
            }
            tmp.isWord = true;
        }
        return root;
    }
}
