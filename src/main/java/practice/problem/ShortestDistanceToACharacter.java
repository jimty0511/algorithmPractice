package practice.problem;

// 821. Shortest Distance to a Character
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C)
                pos = i;
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C)
                pos = i;
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }

    public int[] shortestToCharTwo(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == C ? 0 : n;
        for (int i = 1; i < n; ++i)
            res[i] = Math.min(res[i], res[i - 1] + 1);
        for (int i = n - 2; i >= 0; --i)
            res[i] = Math.min(res[i], res[i + 1] + 1);
        return res;
    }
}
