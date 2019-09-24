package practice.problem;

// 1079. Letter Tile Possibilities
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray())
            count[c - 'A']++;
        return helper(count);
    }

    private int helper(int[] count) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0)
                continue;
            sum++;
            count[i]--;
            sum += helper(count);
            count[i]++;
        }
        return sum;
    }
}
