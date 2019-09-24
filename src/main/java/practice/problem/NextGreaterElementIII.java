package practice.problem;

import java.util.Arrays;

// 556. Next Greater Element III
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] chars = (n + "").toCharArray();
        int i;
        for (i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1])
                break;
        }
        if (i == 0)
            return -1;
        int j = chars.length - 1;
        while (chars[j] <= chars[i - 1])
            j--;
        swap(chars, i - 1, j);
        Arrays.sort(chars, i, chars.length);
        long val = Long.parseLong(new String(chars));
        return val <= Integer.MAX_VALUE ? (int) val : -1;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
