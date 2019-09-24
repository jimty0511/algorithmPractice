package practice.problem;

// 344. Reverse String
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
