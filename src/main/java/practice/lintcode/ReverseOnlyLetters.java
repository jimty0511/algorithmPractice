package practice.lintcode;

// 1725. Reverse Only Letters
public class ReverseOnlyLetters {
    /**
     * @param S: Customary string
     * @return: Reversed string
     */
    public String ReverseOnlyLetters(String S) {
        // write your code here
        char[] chars = S.toCharArray();
        int i = 0, j = S.length() - 1;
        while (i < j) {
            while (!Character.isLetter(chars[i]))
                i++;
            while (!Character.isLetter(chars[j]))
                j--;
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
