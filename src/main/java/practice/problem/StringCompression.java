package practice.problem;

// 443. String Compression
public class StringCompression {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;
        if (chars.length == 1)
            return 1;
        int count = 1, index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
            } else {
                chars[index++] = chars[i];
                if (count > 1) {
                    String num = String.valueOf(count);
                    for (int j = 0; j < num.length(); j++) {
                        chars[index++] = num.charAt(j);
                    }
                    count = 1;
                }
            }
        }
        return index;
    }

    public String compress(String originalString) {
        // write your code here
        if (originalString == null || originalString.length() == 0)
            return "";
        char[] chars = originalString.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            while (i != chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            sb.append(count);
            count = 1;
        }
        return sb.length() < originalString.length() ? sb.toString() : originalString;
    }
}
