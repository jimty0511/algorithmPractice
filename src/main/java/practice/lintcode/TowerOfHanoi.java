package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 169. Tower of Hanoi
public class TowerOfHanoi {
    /**
     * @param n: the number of disks
     * @return: the order of moves
     */
    public List<String> towerOfHanoi(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        helper(n, 'A', 'B', 'C', res);
        return res;
    }

    private void helper(int n, char c1, char c2, char c3, List<String> res) {
        if (n == 1) {
            res.add(move(c1, c3));
            return;
        }
        helper(n - 1, c1, c3, c2, res);
        res.add(move(c1, c3));
        helper(n - 1, c2, c1, c3, res);
    }

    private String move(char from, char to) {
        return "from " + from + " to " + to;
    }
}
