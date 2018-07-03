package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 52. N-Queens II
public class NQueensII {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>();
    private Set<Integer> diag2 = new HashSet<>();
    int count = 0;

    public int totalNQueens(int n) {
        helper(0, n);
        return count;
    }

    private void helper(int row, int n) {
        if (row == n)
            count++;
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
                continue;
            cols.add(i);
            diag1.add(row + i);
            diag2.add(row - i);
            helper(row + 1, n);
            cols.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
}
