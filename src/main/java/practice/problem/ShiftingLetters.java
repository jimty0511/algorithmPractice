package practice.problem;

// 848. Shifting Letters
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        int shift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            chars[i] = (char) ((chars[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(chars);
    }
}
