package practice.problem;

// 389. Find the Difference
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length());
        for (int i = 0; i < s.length(); i++) {
            charCode -= (int) s.charAt(i);
            charCode += (int) t.charAt(i);
        }
        return (char) charCode;
    }

    public char findTheDifferenceBit(String s, String t) {
        int len = t.length();
        char c = t.charAt(len - 1);
        for (int i = 0; i < len - 1; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
