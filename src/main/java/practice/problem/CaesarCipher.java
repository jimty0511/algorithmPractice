package practice.problem;

// Hackerrank
public class CaesarCipher {
    public String caesarCipher(String s, int k) {
        char[] chars = s.toCharArray();
        k = k > 26 ? k % 26 : k;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(chars[i])) {
                if (Character.isLowerCase(chars[i])) {
                    if (chars[i] + k <= 'z') {
                        chars[i] = (char) (chars[i] + k);
                    } else {
                        chars[i] = (char) (chars[i] + k - 26);
                    }
                } else {
                    if (chars[i] + k <= 'Z') {
                        chars[i] = (char) (chars[i] + k);
                    } else {
                        chars[i] = (char) (chars[i] + k - 26);
                    }
                }
            }
        }
        return new String(chars);
    }
}
