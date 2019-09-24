package practice.problem;

// 748. Shortest Completing Word
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();
        int[] targetMap = new int[26];
        for (char c : target.toCharArray()) {
            if (Character.isLetter(c))
                targetMap[c - 'a']++;
        }
        int minLength = Integer.MAX_VALUE;
        String result = null;
        for (String word : words) {
            word = word.toLowerCase();
            if (matches(word, targetMap) && word.length() < minLength) {
                minLength = word.length();
                result = word;
            }
        }
        return result;
    }

    private boolean matches(String word, int[] targetMap) {
        int[] charMap = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c))
                charMap[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (targetMap[i] != 0 && charMap[i] < targetMap[i])
                return false;
        }
        return true;
    }
}
