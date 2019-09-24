package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 118. Pascal's triangle I
public class PascalsTriangleI {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public List<List<Integer>> generateTwo(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            temp.add(0, 1);
            for (int j = 1; j < temp.size() - 1; j++)
                temp.set(j, temp.get(j) + temp.get(j + 1));
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}
