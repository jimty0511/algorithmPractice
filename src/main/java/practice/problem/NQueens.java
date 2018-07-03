package practice.problem;

import java.util.*;

// 51. N-Queens
public class NQueens {

    private Set<Integer> col = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>();
    private Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(0, n, new ArrayList<>(), result);
        return result;
    }

    private void helper(int row, int n, List<String> list, List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
                continue;
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);
            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            helper(row + 1, n, list, result);

            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
}
