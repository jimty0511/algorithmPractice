package practice.problem;

import java.util.LinkedList;
import java.util.List;

// 60. Permutation Sequence
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new LinkedList<>();
        int[] factorials = new int[n];
        StringBuilder sb = new StringBuilder();
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = i * factorials[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        for (int i = n; i > 0; i--) {
            int index = k / factorials[i - 1];
            k = k % factorials[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
        }
        return sb.toString();
    }

    public String getPermutationTwo(int n, int k) {
        List<Integer> numbers = new LinkedList<>();
        int[] factorials = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = i * factorials[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int idx = k / factorials[n - i];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k -= idx * factorials[n - i];
        }
        return sb.toString();
    }
}
