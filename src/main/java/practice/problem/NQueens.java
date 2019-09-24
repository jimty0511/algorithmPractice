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

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueensTwo(int n) {
        boolean[] visited = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];
        helperTwo(n, new ArrayList<>(), visited, diag, antiDiag, 0);
        return result;
    }

    private void helperTwo(int n, List<String> tmp, boolean[] visited, boolean[] diag, boolean[] antiDiag, int idx) {
        if (idx == n) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] || diag[idx - i + n - 1] || antiDiag[idx + i])
                continue;
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            String str = new String(chars);
            tmp.add(str);
            visited[i] = true;
            diag[idx - i + n - 1] = true;
            antiDiag[idx + i] = true;

            helperTwo(n, tmp, visited, diag, antiDiag, idx + 1);

            tmp.remove(tmp.size() - 1);
            chars[i] = '.';
            visited[i] = false;
            diag[idx - i + n - 1] = false;
            antiDiag[idx + i] = false;
        }
    }
}
