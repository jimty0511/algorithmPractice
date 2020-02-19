package practice.problem;

// https://leetcode.com/discuss/interview-question/421975/
public class MinDeletionsToObtainStringInRightFormat {
    public int solution(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] numA = new int[len + 1], numB = new int[len + 1];
        int cntA = 0, cntB = 0, delA = 0, delB = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'B')
                cntB++;
            numB[i + 1] = cntB;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] == 'A')
                cntA++;
            numA[i + 1] = cntA;
        }
        if (cntA == len || cntB == len)
            return 0;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] == 'A') {
                min = Math.min(min, delA + numB[i]);
                delA++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'B') {
                min = Math.min(min, delB + numA[i + 1]);
                delB++;
            }
        }
        return min;
    }
}
