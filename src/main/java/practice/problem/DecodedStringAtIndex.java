package practice.problem;

// 880. Decoded String at Index
public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long N = 0l;
        int i;
        char[] chars = S.toCharArray();
        for (i = 0; N < K; i++) {
            N = Character.isDigit(chars[i]) ? N * (chars[i] - '0') : N + 1;
        }
        i--;
        while (true) {
            if (Character.isDigit(chars[i])) {
                N /= chars[i] - '0';
                K %= N;
            } else if (K % N == 0)
                return "" + chars[i];
            else
                N--;
            i--;
        }
    }
}
