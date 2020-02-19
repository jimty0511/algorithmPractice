package practice.lintcode;

import java.util.Arrays;

// 720. Rearrange a String With Integers
public class RearrangeAStringWithIntegers {
    public String rearrange(String str) {
        // Write your code here
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int res = 0, idx = -1;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                res += c - '0';
                idx++;
            } else
                break;
        }
        if (idx == -1)
            return new String(chars);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = idx + 1; i < chars.length; i++)
                sb.append(chars[i]);
            sb.append(res);
            return sb.toString();
        }
    }

    public String rearrangeTwo(String str) {
        if (str.isEmpty())
            return "";
        int[] chars = new int[26], num = new int[10];
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c))
                num[c - '0']++;
            else
                chars[c - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (chars[i]-- > 0)
                sb.append((char) (i + 'A'));
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            while (num[i]-- > 0)
                sum += i;
        }
        sb.append(sum);
        return sb.toString();
    }
}
