package practice.problem;

// 151. Reverse Words in a String
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i > 0; i--)
            sb.append(parts[i]).append(" ");
        return sb.append(parts[0]).toString();
    }

    public String reverseWordsTwo(String s) {
        StringBuilder sb = new StringBuilder();
        for (int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ')
                continue;
            int end = start;
            while (start >= 0 && s.charAt(start) != ' ')
                start--;
            sb.append(s.substring(start + 1, end + 1)).append(" ");
        }
        return sb.toString().trim();
    }
}
