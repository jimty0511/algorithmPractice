package practice.problem;

// 488. Zuma Game
public class ZumaGame {

    int MAX = 6;

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char c : hand.toCharArray())
            handCount[c - 'A']++;
        int res = helper(board + "#", handCount);
        return res == MAX ? -1 : res;
    }

    private int helper(String s, int[] hand) {
        s = removeConsecutive(s);
        if (s.equals("#")) return 0;
        int rs = MAX, need = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);     //balls need to remove current consecutive balls.
            if (hand[s.charAt(i) - 'A'] >= need) {
                hand[s.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), hand));
                hand[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return rs;
    }

    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(j) == board.charAt(i))
                continue;
            if (j - i >= 3)
                return removeConsecutive(board.substring(0, i) + board.substring(j));
            else
                i = j;
        }
        return board;
    }
}
