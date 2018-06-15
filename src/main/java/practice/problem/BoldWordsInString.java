package practice.problem;

// 758. Bold Words in String
public class BoldWordsInString {
    public String boldWords(String[] words, String S) {
        int[] s = new int[S.length() + 1];
        for (String w : words) {
            int i = 0;
            while ((i = S.indexOf(w, i)) >= 0) {
                s[i]++;
                s[i + w.length()]--;
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int pre = 0, sum = 0;
        for (int i = 0; i <= S.length(); i++) {
            sum += s[i];
            if (sum > 0 && pre == 0)
                sb.append("<b>");
            if (sum == 0 && pre > 0)
                sb.append("</b>");
            if (i < S.length())
                sb.append(S.charAt(i));
            pre = sum;
        }
        return sb.toString();
    }

    public String boldWordsTwo(String[] words, String S) {
        if (words == null || words.length == 0)
            return "";
        boolean[] marked = new boolean[S.length()];
        for (String w : words) {
            markWords(S, w, marked);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (marked[i] && (i == 0 || !marked[i - 1]))
                sb.append("<b>");
            sb.append(S.charAt(i));
            if (marked[i] && (i == S.length() - 1 || !marked[i + 1]))
                sb.append("</b>");
        }
        return sb.toString();
    }

    private void markWords(String S, String w, boolean[] makred) {
        for (int i = 0; i <= S.length() - w.length(); i++) {
            String subString = S.substring(i, i + w.length());
            if (subString.equals(w)) {
                for (int j = i; j < i + w.length(); j++) {
                    makred[j] = true;
                }
            }
        }
    }
}
