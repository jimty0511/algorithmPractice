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
}
