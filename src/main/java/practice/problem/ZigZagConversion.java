package practice.problem;

// 6. ZigZag Conversion
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = s.length();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                stringBuilders[idx].append(chars[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                stringBuilders[idx].append(chars[i++]);
            }
        }
        for (int idx = 1; idx < stringBuilders.length; idx++) {
            stringBuilders[0].append(stringBuilders[idx]);
        }
        return stringBuilders[0].toString();
    }
}
