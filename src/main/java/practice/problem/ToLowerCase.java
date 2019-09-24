package practice.problem;

// 709. To Lower Case
public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z')
                chars[i] = (char) (chars[i] - 'A' + 'a');
        }
        return new String(chars);
    }
}
