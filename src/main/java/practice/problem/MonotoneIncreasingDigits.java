package practice.problem;

// 738. Monotone Increasing Digits
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int mark = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                mark = i - 1;
                chars[i - 1]--;
            }
        }
        for (int i = mark + 1; i < chars.length; i++)
            chars[i] = '9';
        return Integer.parseInt(new String(chars));
    }
}
