package practice.problem;

// 318. Maximum Product of Word Lengths
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > max)) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}
