package practice.problem;

import java.util.Stack;

public class FindPermutation {
    public int[] findPermutationStack(String s) {
        int[] res = new int[s.length() + 1];
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                stack.push(i);
                while (!stack.isEmpty()) {
                    res[j++] = stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        stack.push(s.length() + 1);
        while (!stack.isEmpty())
            res[j++] = stack.pop();
        return res;
    }

    public int[] findPermutationStackReversingSubArray(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'D') {
                int i = j;
                while (j < s.length() && s.charAt(j) == 'D')
                    j++;
                reverse(res, i, j);
            }
        }
        return res;
    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    public int[] findPermutationStackTwoPointers(String s) {
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        int i = 1;
        while (i <= s.length()) {
            res[i] = i + 1;
            int j = i;
            if (s.charAt(i - 1) == 'D') {
                while (i <= s.length() && s.charAt(i - 1) == 'D') {
                    i++;
                }
                for (int k = j - 1, c = i; k <= i - 1; k++, c--) {
                    res[k] = c;
                }
            } else {
                i++;
            }
        }
        return res;
    }
}
