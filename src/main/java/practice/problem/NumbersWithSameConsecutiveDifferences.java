package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 967. Numbers With Same Consecutive Differences
public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> cur = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                if (x > 0 && y + K < 10)
                    temp.add(x * 10 + y + K);
                if (x > 0 && K > 0 && y - K >= 0)
                    temp.add(x * 10 + y - K);
            }
            cur = temp;
        }
        return cur.stream().mapToInt(i -> i).toArray();
    }
}
