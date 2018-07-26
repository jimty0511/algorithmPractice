package practice.problem;

// 345. Reverse Vowels of a String
public class ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }
            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}
